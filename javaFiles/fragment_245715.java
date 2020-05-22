JPanel component = (JPanel) frame.getContentPane();
  component.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
  component.getActionMap().put("space", (new AbstractAction() {
     private boolean firstPress = true;
     private int timerDelay = 250;
     private javax.swing.Timer keyTimer = new javax.swing.Timer(timerDelay , new ActionListener() {

        // Swing Timer's actionPerformed
        public void actionPerformed(ActionEvent e) {
           grid.stepGame();
        }
     });

     // key binding AbstractAction's actionPerformed
     public void actionPerformed(ActionEvent e) {
        if (firstPress) {
           keyTimer.start();
        } else {
           keyTimer.stop();
        }

        firstPress = !firstPress;
     }
  }));