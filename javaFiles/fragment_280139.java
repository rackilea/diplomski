float[]vboData=new float[] { 0,0,0,  1,0,0,  0,1,0 };

FloatBuffer buf = BufferUtils.createFloatBuffer(vboData.length);
buf.put(vboData).flip();

glBufferData(GL_ARRAY_BUFFER, buf, GL_STATIC_DRAW);