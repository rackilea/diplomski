JTextPane pane = new JTextPane();
pane.setText("Something html\r\nSomething html");
StyledDocument document = pane.getStyledDocument();
String text2 = pane.getText();
String text1 = document.getText(0, document.getLength());
System.out.println(text1.equals(text2));