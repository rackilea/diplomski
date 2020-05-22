public boolean startRecord() {
    if (mediaProjection == null || running) {
        return false;
    }

    initRecorder();
    createVirtualDisplay(); // no additional check
    mediaRecorder.start();
    running = true;
    return true;
}