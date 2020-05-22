GL2 gl = dc.getGL().getGL2(); // GL initialization checks for GL2 compatibility.

int attrMask =
        GL2.GL_DEPTH_BUFFER_BIT // for depth test, depth mask and depth func
            ... bunch more bits being set ...

gl.glPushAttrib(attrMask);

if (!dc.isPickingMode())
{
    gl.glEnable(GL.GL_BLEND);
    OGLUtil.applyBlending(gl, false);
}