public void windowDeactivated(WindowEvent e) {
        if(e.getOppositeWindow() == null){
            // will be null when another application window gets activated, stop recording
        }
        for(Window w : appFrame.getOwnedWindows()){
            if(w.equals(e.getOppositeWindow())){
                // one of the windows owned by the frame is active, don't stop recording
            }
        }

    }