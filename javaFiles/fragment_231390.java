Action generateClick = new AbstractAction() {
  public void actionPerformed(ActionEvent e) {
      JButton butt = (JButton) e.getSource();
      butt.doClick();
  }
 };