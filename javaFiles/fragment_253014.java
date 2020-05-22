int colAttrib = glGetAttribLocation(Shaders.shaderProgram, "color");
    glEnableVertexAttribArray(colAttrib);
    glVertexAttribPointer(colAttrib, 3, GL_FLOAT, false, (Float.SIZE / 8) * 8, (Float.SIZE / 8) * 3);

    int texAttrib = glGetAttribLocation(Shaders.shaderProgram, "texcoord");
    glEnableVertexAttribArray(texAttrib);
    glVertexAttribPointer(texAttrib, 2, GL_FLOAT, false, (Float.SIZE / 8) * 8, (Float.SIZE / 8) * 6);