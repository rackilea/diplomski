public FrameGUI(String title) {
  super(title);
  setLayout(new BorderLayout());

  final JTextArea textArea = new JTextArea();  //  *****
  detailsPanel = new DetailsPanel();
  Container c = getContentPane();
  c.add(textArea, BorderLayout.CENTER);
  c.add(detailsPanel, BorderLayout.NORTH);
}