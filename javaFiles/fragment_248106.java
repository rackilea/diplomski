textbox1.setBackground(Color.yellow);
int delayTime = 3 * 1000; // 3 seconds
new Timer(delayTime, new ActionListener() {
  public void actionPerformed(ActionEvent e) {
     textbox1.setBackground(Color.white);
     // stop the timer
     ((Timer) e.getSource()).stop();
  }
}).start();