frame.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentMoved(ComponentEvent event) {
            if (isMaximized()) {
                model.setFrameOrigin(frame.getLocation());
            } else {
                model.setFrameBounds(frame.getBounds());
            }
            model.setFrameState(frame.getExtendedState());
        }
        @Override
        public void componentResized(ComponentEvent event) {
            model.setFrameState(frame.getExtendedState());
        }
    });