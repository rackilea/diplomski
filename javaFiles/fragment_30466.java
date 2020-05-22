SimpleAttributeSet green = new SimpleAttributeSet();
StyleConstants.setForeground(green, Color.GREEN);

SimpleAttributeSet right = new SimpleAttributeSet();
StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);

try
{
    doc.insertString(0, txtio.getSelectedText(), green);
    doc.setParagraphAttributes(0, 1, right, false);
}
catch(Exception e) {}