public static String getHTMLContent(HTMLDocument htmlDoc, int startOffset, int length) {
    StringWriter writer = new StringWriter();
    try {
        new HTMLEditorKit().write(writer, htmlDoc, startOffset, length);
    } catch (IOException | BadLocationException ex) {
        Logger.getLogger(Editeur.class.getName()).log(Level.SEVERE, null, ex);
    }
    String html = writer.toString();
    return html;
}