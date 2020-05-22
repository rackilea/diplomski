static class TextAreaRenderer extends JTextPane implements TableCellRenderer {

  private final DefaultTableCellRenderer adaptee = new DefaultTableCellRenderer();
  /** map from table to map of rows to map of column heights */
  private final Map cellSizes = new HashMap();

  public TextAreaRenderer() {
     // !! setLineWrap(true);
     // setWrapStyleWord(true);

     StyledDocument doc = getStyledDocument();
     SimpleAttributeSet center = new SimpleAttributeSet();
     StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
     doc.setParagraphAttributes(0, doc.getLength(), center, false);
  }