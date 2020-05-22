java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            // this will be run on the EDT
            new UserInterface().setVisible(true);
        }
    });