FloatBuffer vBuff = BufferUtils.createFloatBuffer(6);
vBuff.put(tri);
vBuff.flip();

while(!glfwWindowShouldClose(windowID)) {
    glClear(GL_COLOR_BUFFER_BIT);

    glEnableClientState(GL_VERTEX_ARRAY);
    glVertexPointer(2, GL_FLOAT, 0, vBuff);
    glDrawArrays(GL_TRIANGLES, 0, 6);
    glDisableClientState(GL_VERTEX_ARRAY);

    glfwSwapBuffers(windowID);
    glfwPollEvents();
}