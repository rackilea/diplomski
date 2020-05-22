protected void onBeforeRender() {
...
    if (!hasBeenRendered()) {
        onInitialize();
    }
...
}