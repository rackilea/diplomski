jPanel.addComponentListener(new ComponentAdapter() {
        @Override 
        public void componentShown(java.awt.event.ComponentEvent e) 
        {
            jTextField.requestFocusInWindow();
        }
    });