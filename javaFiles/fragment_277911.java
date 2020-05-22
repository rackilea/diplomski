@SuppressWarnings("serial")
static class Test extends JFrame {
  public Test() {           
    this.setSize(400, 400);
    int size = 8;

    JPanel content = new JPanel(new GridLayout(size,size));

    for (int i = 0; i < size*size; ++i) {
      JPanel panel = new JPanel();
      panel.setBackground( i % 2 == i/size % 2 ? Color.RED : Color.BLUE);
      content.add(panel);
    }
    this.add(content);
  }
}