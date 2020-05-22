public void dispose() {
    try (MemoryStack stack = stackPush()) {
        IntBuffer width = stack.ints(1);
        IntBuffer height = stack.ints(1);
        glfwGetWindowSize(windowID, width, height);
        configuration.width = width.get();
        configuration.height = height.get();
    }
}