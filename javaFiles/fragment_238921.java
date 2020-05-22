JEditorPane pane = new JEditorPane("text/html", "");

pane.setText("<html>One line</html>");
System.out.println(pane.getPreferredSize());
pane.setText("<html>Line one<br />Line 2<br />Third line<br />Line four</html>");

// get width from initial preferred size, height should be much larger than necessary
pane.setSize(61, 1000);

System.out.println(pane.getPreferredSize());