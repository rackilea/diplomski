fbo = GL30.glGenFramebuffers();
GL30.glBindFramebuffer(GL30.GL_FRAMEBUFFER, fbo);

rbo = GL30.glGenRenderbuffers();
GL30.glBindRenderbuffer(GL30.GL_RENDERBUFFER, rbo);
GL30.glRenderbufferStorage(GL30.GL_RENDERBUFFER, GL11.GL_RGBA8, 640, 480);
GL30.glFramebufferRenderbuffer(GL30.GL_FRAMEBUFFER, GL30.GL_COLOR_ATTACHMENT0, GL30.GL_RENDERBUFFER, rbo);

assert(GL30.glCheckFramebufferStatus(GL30.GL_FRAMEBUFFER) == GL30.GL_FRAMEBUFFER_COMPLETE);

GL30.glBindFramebuffer(GL30.GL_DRAW_FRAMEBUFFER, fbo);
GL20.glDrawBuffers(GL30.GL_COLOR_ATTACHMENT0);
GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

drawScene(); //draw here