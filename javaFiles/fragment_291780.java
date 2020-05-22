... 
public void activateFrame(JInternalFrame f) {
    JInternalFrame currentFrame = currentFrameRef != null ? 
        currentFrameRef.get() : null;
    try {
        super.activateFrame(f);
        if (currentFrame != null && f != currentFrame) {