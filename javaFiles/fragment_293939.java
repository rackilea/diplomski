private static int createIndexBuffer(int[] indices) {
    int indexBufferObjectID = glGenBuffers();
    ibos.add(indexBufferObjectID);                                                          
    //Adding the IBO to the list of all IBOs
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBufferObjectID);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, BufferUtils.createIntBuffer(indices), GL_STATIC_DRAW);

    // glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0); <----- delete

    return indexBufferObjectID;
}