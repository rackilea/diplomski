class Window {
    final long handle;

    int width;
    int height;

    WindowObserver observer;

    Window(final long handle, final int width, final int height) {
        this.handle = handle;
        this.width = width;
        this.height = height;

        glfwSetWindowSizeCallback(handle, (handle, w, h) -> {
            if (observer != null) {
                observer.windowDidResize(this, this.width, this.height, w, h);
            }

            this.width = w;
            this.height = h;
        });
    }
}