int delay = 1000;
new Timer(delay, new ActionListener() {
  private int i = 0;

  @Override
  public void actionPerformed(ActionEvent e) {
     if (i < listData.size()) {
       ascii.setText(listData.get(i));
     } else {
       ((Timer) e.getSource()).stop();
     }
     i++;
  }
}).start();