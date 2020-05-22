if (evt.getKeyCode() == 10) {
  try {
    int offset=ta.getLineOfOffset(ta.getCaretPosition());
    int start=ta.getLineStartOffset(offset);
    int end=ta.getLineEndOffset(offset);

    System.out.println("Text: "+ta.getText(start, (end-start)));                
  } catch (BadLocationException ex) {
    System.out.println(ex.getMessage());
  }
}