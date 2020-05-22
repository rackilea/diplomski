frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent e) {
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                // or go to fullscreen mode here
            }
        });