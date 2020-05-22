int texCoordBuffer;
glGenBuffers(1, texCoordBuffer);

float[] texCoord = new float[] { 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f };

glBindBuffer(GL_ARRAY_BUFFER, texCoordBuffer);
glBufferData(GL_ARRAY_BUFFER, RenderUtil.createBuffer(texCoord), GL_STATIC_DRAW);

int tax_attr_i = 1; // layout(location = 1) in vec2 textures;
glVertexAttribPointer(tax_attr_i, 2, GL_FLOAT, false, 0, 0);