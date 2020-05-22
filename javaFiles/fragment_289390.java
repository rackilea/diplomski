public void init(GL2 gl2)
{
    int[] params1 = new int[1];
    gl2.glGenTextures(1, params1, 0);
    textureID = params1[0];
    gl2.glBindTexture(GL.GL_TEXTURE_2D, textureID);
    gl2.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
    gl2.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
    gl2.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA8, Game.RES_WIDTH, Game.RES_HEIGHT, 0, GL.GL_BGRA, GL.GL_UNSIGNED_BYTE, null);

    int[] params2 = new int[1];
    gl2.glGenFramebuffers(1, params2, 0);
    frameBufferID = params2[0];
    gl2.glBindFramebuffer(GL2.GL_DRAW_FRAMEBUFFER, frameBufferID);
    gl2.glFramebufferTexture2D(GL2.GL_DRAW_FRAMEBUFFER, GL.GL_COLOR_ATTACHMENT0, GL.GL_TEXTURE_2D, textureID, 0);

    gl2.glBindFramebuffer(GL2.GL_DRAW_FRAMEBUFFER, 0);
}