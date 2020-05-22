FloatBuffer posBuffer = MemoryUtil.memAllocFloat(posData.length);
posBuffer.put(posData).flip();
FloatBuffer texBuffer = MemoryUtil.memAllocFloat(texData.length);
texBuffer.put(texData).flip();

int vboPosObj = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vboPosObj);
glBufferData(GL_ARRAY_BUFFER, posBuffer, GL_STATIC_DRAW);

// index 0 to associate with "in_Position"            
glVertexAttribPointer(0, 4, GL_FLOAT, false, 0, 0); 
glEnableVertexAttribArray(0); // 0 = attribute index of "in_Position"

int vboTexObj = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vboTexObj);
glBufferData(GL_ARRAY_BUFFER, texBuffer, GL_STATIC_DRAW);

// index 0 to associate with "in_TextureCoord"
glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);
glEnableVertexAttribArray(1); // 1 = attribute index of "in_TextureCoord"