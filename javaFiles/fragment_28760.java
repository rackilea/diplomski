Component c = getFocusOwner();
if(c==html){
    HTMLEditorKit kit = (HTMLEditorKit) html.getEditorKit();
    HTMLDocument doc = (HTMLDocument) html.getStyledDocument();
    kit.insertHTML(doc, html.getCaretPosition(), builder.toString(), 0, 0, null);
}else if(c==text){
    text.getStyledDocument().insertString(text.getCaretPosition(), builder.toString(), null);
}