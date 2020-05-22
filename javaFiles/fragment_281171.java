int samplerHandle = GLES20.glGetUniformLocation(mTextureShaderProgram, "s_texture");
GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, texturenames[textureIndex]);
GLES20.glUniform1i(samplerHandle, 0);

GLES20.glDrawElements(GLES20.GL_TRIANGLES, drawOrder.length,
                      GLES20.GL_UNSIGNED_SHORT, indexBuffer);