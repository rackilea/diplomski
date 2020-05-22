final JDialog dialog = new JDialog();
    dialog.setTitle("Test Input");
    dialog.setModal(true);


    dialog.addWindowFocusListener(new WindowFocusListener() {

        @Override
        public void windowLostFocus(WindowEvent arg0) {

        }

        @Override
        public void windowGainedFocus(WindowEvent arg0) {
            frame.toFront();        
        }
    });