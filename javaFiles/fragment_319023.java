ActionListener actionListener = new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    // check selected states of both button one and two and set font accordingly
    // you can use if (foo && bar) {...}
    // else if (foo) {...}
    // else if (bar) {...}
    // else {.. default...}
  }
};
button1.addActionListener(actionListener);
button2.addActionListener(actionListener);