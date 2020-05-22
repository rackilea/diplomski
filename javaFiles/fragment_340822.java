fbo_handle = glGenFramebuffers();
this.texture_handle = glGenTextures();
rbo_depth_buffer_handle = glGenRenderbuffers();

glBindFramebuffer(GL_FRAMEBUFFER, fbo_handle);

glBindTexture(GL_TEXTURE_2D, texture_handle);

glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

glTexParameteri(GL_TEXTURE_2D, GL_GENERATE_MIPMAP, GL_TRUE);
glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, width, height, 0, GL_RGBA, GL_INT, (ByteBuffer) null);

glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, texture_handle, 0);

glBindRenderbuffer(GL_RENDERBUFFER, rbo_depth_buffer_handle);
glRenderbufferStorage(GL_RENDERBUFFER, GL_DEPTH_COMPONENT24, width, height);
glFramebufferRenderbuffer(GL_FRAMEBUFFER, GL_DEPTH_ATTACHMENT, GL_RENDERBUFFER, rbo_depth_buffer_handle);

if (glCheckFramebufferStatus(GL_FRAMEBUFFER) != GL_FRAMEBUFFER_COMPLETE)
{
    System.err.println("Framebuffer configuration error");
}

glBindTexture(GL_TEXTURE_2D, 0);

glBindFramebuffer(GL_FRAMEBUFFER, 0);