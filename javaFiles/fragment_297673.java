frame.addWindowFocusListener(new WindowFocusListener() {
        @Override
        public void windowGainedFocus(WindowEvent e) {
            if (e.getOppositeWindow()==null) {
                <do something when we gain focus>
            }
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
          <do something else when we lose focus>
        }
    });