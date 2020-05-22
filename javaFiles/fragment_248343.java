glBindFrameBuffer((GL_DRAW_FRAMEBUFFER, yourFbo);

   drawSceneObjects(gl);

glBindFrameBuffer((GL_READ_FRAMEBUFFER, yourFbo);

   readPixelsHere()


 glBindFrameBuffer((GL_FRAMEBUFFER, 0);///switch to default FBO