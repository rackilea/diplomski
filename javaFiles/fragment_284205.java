private class MyDocumentFilter extends DocumentFilter {

  @Override
  public void insertString(DocumentFilter.FilterBypass fb, int offset,
        String string, AttributeSet attr) throws BadLocationException {

     JOptionPane.showMessageDialog(null, "Enter hereeeeeeeee");

     super.insertString(fb, offset, string, attr);
  }

  @Override
  public void replace(FilterBypass fb, int offset, int length, String text,
        AttributeSet attrs) throws BadLocationException {
     JOptionPane.showMessageDialog(null, "This is really what you should be overriding");
     super.replace(fb, offset, length, text, attrs);
  }

  @Override
  public void remove(FilterBypass fb, int offset, int length)
        throws BadLocationException {
     JOptionPane.showMessageDialog(null, "and don't forget this!");
     super.remove(fb, offset, length);
  }
}