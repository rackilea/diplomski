FloatBuffer verticesFloatBuffer = BufferUtils.createFloatBuffer(verticesCount * 36);
for (VertexData vert : vertices) {verticesFloatBuffer.put(vert.getElements());}
vertices.clear();
verticesFloatBuffer.flip();

GL30.glBindVertexArray(vaoId);

GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboId);
GL15.glBufferData(GL15.GL_ARRAY_BUFFER, verticesFloatBuffer, GL15.GL_STATIC_DRAW);

GL20.glEnableVertexAttribArray(0);
GL20.glEnableVertexAttribArray(1);
GL20.glEnableVertexAttribArray(2);
GL20.glEnableVertexAttribArray(3);

GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 36, 0);
GL20.glVertexAttribPointer(1, 2, GL11.GL_FLOAT, false, 36, 12);
GL20.glVertexAttribPointer(2, 3, GL11.GL_FLOAT, false, 36, 20);
GL20.glVertexAttribPointer(3, 1, GL11.GL_FLOAT, false, 36, 32);

GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);