public void addVertex(Vector3f vertex, int position)
{
    if (meshType == 1)
    {
        FloatBuffer subDataF = null;
        IntBuffer subDataI = null;
        int vboID;

        lineCount = position+1;

        try
        {
            vboID = vboIDList.get(0);
            float[] vert = new float[]{vertex.x, vertex.y, vertex.z};
            subDataF = MemoryUtil.memAllocFloat(vert.length);        // !!! Must Be manually freed!
            subDataF.put(vert).flip();
            glBindBuffer(GL_ARRAY_BUFFER, vboID);
            glBufferSubData(GL_ARRAY_BUFFER, (long)(position * 3 * 4), (FloatBuffer)subDataF);
            glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

            vboID = vboIDList.get(1);
            int[] index = new int[]{ position };
            subDataI = MemoryUtil.memAllocInt(index.length);        // !!! Must Be manually freed!
            subDataI.put(index).flip();
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboID);
            glBufferSubData(GL_ELEMENT_ARRAY_BUFFER, (long)(position * 4), (IntBuffer)subDataI);

            glBindBuffer(GL_ARRAY_BUFFER, 0);
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
        }
        finally
        {
            if (subDataF != null)
            {
                MemoryUtil.memFree(subDataF);
            }
            if (subDataI != null)
            {
                MemoryUtil.memFree(subDataI);
            }
        }
    }
}