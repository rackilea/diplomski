Frame[] frames = JFrame.getFrames();
    for (Frame frame : frames) {
        if (frame.isActive()) {
            return frame;
        }
    }
    for (Frame frame : frames) {
        if (frame.isVisible()) {
            return frame;
        }
    }