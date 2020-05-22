DefaultStyledDocument document = new DefaultStyledDocument();
JTextPane textpane = new JTextPane(document);
StyleContext context = new StyleContext();
// build a style
Style style = context.addStyle("test", null);
// set some style color
StyleConstants.setForeground(style, Color.RED);
// add some data to the document
document.insertString(0, "", style);


OR




JTextPane pane = new JTextPane();
SimpleAttributeSet set = new SimpleAttributeSet();
StyleConstants.setForeground(set, Color.red);
Document doc = pane.getStyledDocument();
doc.insertString(doc.getLength(), "Kleine ", set);