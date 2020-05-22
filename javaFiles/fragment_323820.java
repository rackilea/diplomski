public void insertHTML(int offset, String htmlText) throws BadLocationException, IOException {
    if (getParser() == null)
        throw new IllegalStateException("No HTMLEditorKit.Parser");

    Element elem = getCurrentElement(offset);

    //the method insertHTML is not visible
    try {
        Method insertHTML = javax.swing.text.html.HTMLDocument.class.getDeclaredMethod("insertHTML",
                new Class[] {Element.class, int.class, String.class, boolean.class});
        insertHTML.setAccessible(true);
        insertHTML.invoke(this, new Object[] {elem, offset, htmlText, false});
    }
    catch (Exception e) {
        throw new IOException("The method insertHTML() could not be invoked", e);
    }
}