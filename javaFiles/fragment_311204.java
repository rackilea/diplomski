int timerDelay = 20;
new Timer(timerDelay, new ActionListener(){
  public void actionPerformed(ActionEvent e) {
    x = randomposition(x);
    y = randomposition(y);
    repaint();
  }
}).start();