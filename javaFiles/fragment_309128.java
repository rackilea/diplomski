while ( glfwWindowShouldClose(window) == GL_FALSE ) {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

    /* Switch permanently between red and green background color
        - doesn't work, no blinking, just green background color */ 
    glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
    glClearColor(0.0f, 1.0f, 0.0f, 0.0f);

    glfwSwapBuffers(window); // swap the color buffers

    // Poll for window events. The key callback above will only be
    // invoked during this call.
    glfwPollEvents();
}