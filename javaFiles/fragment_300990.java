SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame.setDefaultLookAndFeelDecorated(false);
            MasterWin win = new MasterWin(input);
        };
    });