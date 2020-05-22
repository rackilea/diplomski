public void drawWorld(){
  guy.setBounds(counterVariable,0,50,50);
  int timerDelay = 100;
  new javax.swing.Timer(timerDelay, new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
      countVariable++;
      guy.setBounds(counterVariable,0,50,50);
      panel.repaint();
    }
  }).start;
}