protected void doDrawOrderedRenderable(DrawContext dc, PickSupport pickCandidates, OrderedPlacemark opm)
{
    if (this.isDrawLine(dc, opm))
        this.drawLine(dc, pickCandidates, opm);

    if (this.activeTexture == null)
    {
        if (this.isDrawPoint(dc))
            this.drawPoint(dc, pickCandidates, opm);
        return;
    }

    GL2 gl = dc.getGL().getGL2(); // GL initialization checks for GL2 compatibility.

    OGLStackHandler osh = new OGLStackHandler();
    try
    {
        if (dc.isPickingMode())
        {
            // Set up to replace the non-transparent texture colors with the single pick color.
            gl.glEnable(GL.GL_TEXTURE_2D);
            gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_COMBINE);
            gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_SRC0_RGB, GL2.GL_PREVIOUS);
            gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_COMBINE_RGB, GL2.GL_REPLACE);

            Color pickColor = dc.getUniquePickColor();
            pickCandidates.addPickableObject(this.createPickedObject(dc, pickColor));
            gl.glColor3ub((byte) pickColor.getRed(), (byte) pickColor.getGreen(), (byte) pickColor.getBlue());
        }
        else
        {
            gl.glEnable(GL.GL_TEXTURE_2D);
            Color color = this.getActiveAttributes().getImageColor();
            if (color == null)
                color = PointPlacemarkAttributes.DEFAULT_IMAGE_COLOR;
            gl.glColor4ub((byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue(),
                (byte) color.getAlpha());
        }

        // This was relocated from the check in version.
        // Compute the scale
        double xscale;
        Double scale = this.getActiveAttributes().getScale();
        if (scale != null)
            xscale = scale * this.activeTexture.getWidth(dc);
        else
            xscale = this.activeTexture.getWidth(dc);

        double yscale;
        if (scale != null)
            yscale = scale * this.activeTexture.getHeight(dc);
        else
            yscale = this.activeTexture.getHeight(dc);
        double maxwh = Math.max(xscale, yscale);

        // The image is drawn using a parallel projection.
        // This came from the fix in https://stackoverflow.com/questions/49637844/worldwind-pointplacemark-pitch
        osh.pushProjectionIdentity(gl);
        gl.glOrtho(0d, dc.getView().getViewport().width, 0d, dc.getView().getViewport().height, -0.6 * maxwh, 0.6 * maxwh);

        // Apply the depth buffer but don't change it (for screen-space shapes).
        if ((!dc.isDeepPickingEnabled()))
            gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthMask(false);

        // Suppress any fully transparent image pixels.
        gl.glEnable(GL2.GL_ALPHA_TEST);
        gl.glAlphaFunc(GL2.GL_GREATER, 0.001f);

        // Adjust depth of image to bring it slightly forward
        double depth = opm.screenPoint.z - (8d * 0.00048875809d);
        depth = depth < 0d ? 0d : (depth > 1d ? 1d : depth);
        gl.glDepthFunc(GL.GL_LESS);
        gl.glDepthRange(depth, depth);

        // The image is drawn using a translated and scaled unit quad.
        // Translate to screen point and adjust to align hot spot.
        osh.pushModelviewIdentity(gl);
        gl.glTranslated(opm.screenPoint.x + this.dx, opm.screenPoint.y + this.dy, 0);

        Double heading = getActiveAttributes().getHeading();
        Double pitch =          this.computePitch(dc.getView());

        // Adjust heading to be relative to globe or screen
        if (heading != null)
        {
            if (AVKey.RELATIVE_TO_GLOBE.equals(this.getActiveAttributes().getHeadingReference()))
                heading = dc.getView().getHeading().degrees - heading;
            else
                heading = -heading;
        }

        // Apply the heading and pitch if specified.
        if (heading != null || pitch != null)
        {
            gl.glTranslated(xscale / 2, yscale / 2, 0);
            if (pitch != null)
                gl.glRotated(pitch, 1, 0, 0);
            if (heading != null)
                gl.glRotated(heading, 0, 0, 1);
            gl.glTranslated(-xscale / 2, -yscale / 2, 0);
        }

        // Scale the unit quad
        gl.glScaled(xscale, yscale, 1);

        if (this.activeTexture.bind(dc))
            dc.drawUnitQuad(activeTexture.getTexCoords());

        gl.glDepthRange(0, 1); // reset depth range to the OGL default

        if (this.mustDrawLabel())
        {
            if (!dc.isPickingMode() || this.isEnableLabelPicking())
                this.drawLabel(dc, pickCandidates, opm);
        }
    }
    finally
    {
        if (dc.isPickingMode())
        {
            gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, OGLUtil.DEFAULT_TEX_ENV_MODE);
            gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_SRC0_RGB, OGLUtil.DEFAULT_SRC0_RGB);
            gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_COMBINE_RGB, OGLUtil.DEFAULT_COMBINE_RGB);
        }

        gl.glDisable(GL.GL_TEXTURE_2D);
        osh.pop(gl);
    }
}