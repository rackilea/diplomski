private void update(DocumentEvent e) {
  String text;
  try {
     Document doc = e.getDocument();
     text = e.getDocument().getText(0, doc.getLength());
     // do something with text here! ************
     System.out.println(text);
  } catch (BadLocationException e1) {
     e1.printStackTrace();
  }
}