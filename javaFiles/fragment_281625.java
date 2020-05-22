JFileChooser chooser = new JFileChooser();
chooser.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO - wire into something
    System.out.println(e);
  }
});

JTextField field = new JTextField("Hello, World");

JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());
panel.add(chooser, BorderLayout.CENTER);
panel.add(field, BorderLayout.SOUTH);