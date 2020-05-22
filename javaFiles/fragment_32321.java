frame.pack();
    if (options.getFrameBounds().getWidth() > 0) {
        frame.setExtendedState(options.getState());
        if (isMaximized()) {
            frame.setLocation(options.getFrameOrigin());
        } else {
            frame.setBounds(options.getFrameBounds());
        }
    }
    model.setFrameState(frame.getExtendedState());
    model.setFrameBounds(frame.getBounds());
    model.setFrameOrigin(frame.getLocation());