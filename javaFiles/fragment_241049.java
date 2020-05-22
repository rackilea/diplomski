public Mesh(float[] vertex, int size)
{
    texture = null;
    meshType = 1;           //will draw lines

    FloatBuffer verticesBuffer = null;
    IntBuffer indicesBuffer = null;
    int vboID;

    try
    {
        vertexCount = size;

        vaoID = glGenVertexArrays();
        glBindVertexArray(vaoID);

        vboIDList = new ArrayList<>();

        // Vertices VBO generation
        vboID = glGenBuffers();
        vboIDList.add(vboID);
        verticesBuffer = MemoryUtil.memAllocFloat(size * 3);        // !!! Must Be manually freed!
        verticesBuffer.put(vertex).put(new float[size*3 - 3]).flip();
        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        vertexAttrArrCount += 1;

        // Indices VBO generation
        vboID = glGenBuffers();
        vboIDList.add(vboID);
        indicesBuffer = MemoryUtil.memAllocInt(size);             // !!! Must be manually freed!
        indicesBuffer.put(new int[size]).flip();                  // I need the first element 0 anyway
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);

        // unbinding
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);
    }
    finally
    {
        if (verticesBuffer != null)
        {
            MemoryUtil.memFree(verticesBuffer);                             // Freeing vertex buffer
        }

        if (indicesBuffer != null)
        {
            MemoryUtil.memFree(indicesBuffer);                              // Freeing indices buffer
        }
    }

}