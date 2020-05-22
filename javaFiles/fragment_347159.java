//int len = pane.getDocument().getLength();
//pane.setCaretPosition(len);
//pane.setCharacterAttributes(aset, false);
//pane.replaceSelection(text + "\n");

try
{
    StyledDocument doc = pane.getStyledDocument();
    doc.insertString(doc.getLength(), text, aset);
}
catch(BadLocationException e) { System.out.println(e); }