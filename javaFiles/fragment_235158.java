@Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();

    if (new String(passwordField.getPassword()).equals("1234") && (userField.getText()
        .equals("tomek"))) {
      frame.getContentPane().setBackground(Color.GREEN);
    } else {
      frame.getContentPane().setBackground(Color.RED);
    }
  }