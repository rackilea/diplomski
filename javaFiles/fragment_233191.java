for (int i = 0; i < lmNames.length; i++) {
  ....
  lLabel.setToolTipText("ToolTip for label number: " + (i+1));
  panel1.add(p,gborders[i]);
}
frame.add(panel1);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setVisible(true);