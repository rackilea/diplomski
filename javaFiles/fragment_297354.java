// store the current model matrix
GL11.glPushMatrix();

// bind to the appropriate texture for this image
this.texture.bind();

// translate to the right location and prepare to draw
GL11.glColor3f(1, 1, 1);
GL11.glTranslated(x + (this.texture.getImageWidth() / 2), y + (this.texture.getImageHeight() / 2), 0);

GL11.glRotated(this.angle, 0, 0, 1);
GL11.glTranslated(-this.texture.getImageWidth() / 2, -this.texture.getImageHeight() / 2, 0);
    // draw a quad textured to match the sprite
    GL11.glBegin(GL11.GL_QUADS);
    {
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(0, 0);
        GL11.glTexCoord2f(0, this.texture.getHeight());
        GL11.glVertex2f(0, this.texture.getImageHeight());
        GL11.glTexCoord2f(this.texture.getWidth(), this.texture.getHeight());
        GL11.glVertex2f(this.texture.getImageWidth(), this.texture.getImageHeight());
        GL11.glTexCoord2f(this.texture.getWidth(), 0);
        GL11.glVertex2f(this.texture.getImageWidth(), 0);
    }
    GL11.glEnd();

    // restore the model view matrix to prevent contamination
    GL11.glPopMatrix();