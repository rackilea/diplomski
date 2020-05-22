GL20.glActiveTexture(GL20.GL_TEXTURE0+2);
GL20.glBindTexture(GL20.GL_TEXTURE_2D, cbTexHandle);
program.setUniformi("u_texture_cb", GL20.GL_TEXTURE0+2);

GL20.glActiveTexture(GL20.GL_TEXTURE0+1);
GL20.glBindTexture(GL20.GL_TEXTURE_2D, crTexHandle);
program.setUniformi("u_texture_cr", GL20.GL_TEXTURE0+1);