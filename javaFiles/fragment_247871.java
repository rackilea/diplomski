private JPanel northPanel = new JPanel();
private JPanel southPanel = new JPanel();
private JLabel label1 = new JLabel("remove this");

// ....


@Override
 public void actionPerformed(ActionEvent e) {
  // ...

  label1.setText("new text");

  // ...
 }