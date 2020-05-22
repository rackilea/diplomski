while ( glfwWindowShouldClose(window) == GL_FALSE ) {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    render();
    glfwSwapBuffers(window);
    glfwPollEvents();
}