public void append(String append,Color fg,Color bg, boolean bold,boolean italic, boolean underline) {
    try {
        // Get the text pane's document                        
        StyledDocument doc = (StyledDocument)this.getDocument();

        // The color must first be wrapped in a style
        Style style = doc.addStyle("StyleName", null);
        StyleConstants.setForeground(style, fg);
        StyleConstants.setBackground(style,bg);
        StyleConstants.setBold(style,bold);
        StyleConstants.setItalic(style,italic);
        StyleConstants.setUnderline(style,underline);


        // Insert the text at the end of the text
        doc.insertString(doc.getLength(), append, style);
    } catch (Exception e) {
        e.printStackTrace();
    }

    this.setCaretPosition (this.getDocument().getLength()-1);
}