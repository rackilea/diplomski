FloatBuffer ambient = BufferUtils.createFloatBuffer(4);
ambient.put(new float[] { 0.05f, 0.05f, 0.05f, 1f, });
ambient.flip();    

FloatBuffer position = BufferUtils.createFloatBuffer(4);
position.put(new float[] { 0f, 0f, 0f, 1f, });
position.flip();    

glEnable(GL_LIGHTING);
glEnable(GL_LIGHT0);
glLightModel(GL_LIGHT_MODEL_AMBIENT, ambient);
glLight(GL_LIGHT0, GL_POSITION, position);