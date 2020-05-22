final Button b = ...;
final Color[] colors = ...;
colors[0] = Color.RED;
colors[1] = Color.LIGHT_GREY;
ActionListener al = new ActionListener() {
  int loop = 0;
  public void actionPerformed(ActionEvent ae) {
    loop = (loop + 1) % colors.length;
    b.setBackground(colors[loop]);
  }
}

new Timer(200, al).start();