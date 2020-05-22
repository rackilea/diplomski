public MemberPanel(int i) throws IOException {
  Container contentPane = getContentPane();
  GridLayout layout = new GridLayout(2, 1);
  contentPane.setLayout(layout);
  setVisible(true);  // ****** here

  // .....

  // only now do you add components...
  contentPane.add(buttonPanel);
  contentPane.add(textFieldPanel);

}