/** for the repetition of road.*/ 
_acceleration += -0.005f * (float)System.currentTimeMillis()-startTime;            
_acceleration = Math.max(_acceleration, 0.002f);
texturePos += acceleration;
gl.glMatrixMode(GL10.GL_TEXTURE);
gl.glPushMatrix();
gl.glTranslatef(0, texturePos, 0);
gl.glMatrixMode(GL10.GL_MODELVIEW);
incrementTex -= _acceleration;