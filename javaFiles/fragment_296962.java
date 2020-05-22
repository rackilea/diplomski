// Timer is a swing timer
Timer timer = new Timer(
    100, 
    new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            // main frame is your main animation canvas (eg a JFrame)
            mainFrame.repaint();
        }
    });
timer.start();