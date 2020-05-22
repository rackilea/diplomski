private GLFWKeyCallback keyCallback;

// ...

keyCallback = new GLFWKeyCallback() {
    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        if (action == GLFW_PRESS) {
            if (key == GLFW_KEY_UP && /*...*/) {
                // ...
            }
            if (key == GLFW_KEY_DOWN && /*...*/) {
                // ...
            }
        }
    }
}
glfwSetKeyCallback(window, keyCallback);