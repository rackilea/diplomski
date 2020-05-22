class CustomEditorKit extends HTMLEditorKit {
    @Override
    public void write(Writer out, Document doc, int pos, int len) throws IOException, BadLocationException {
        HTMLWriterHack writer = new HTMLWriterHack(out, (HTMLDocumentHack) doc);
        writer.write();
    }
    @Override
    public Document createDefaultDocument() {
        StyleSheet styles = getStyleSheet();
        StyleSheet ss = new StyleSheet();
        ss.addStyleSheet(styles);
        HTMLDocumentHack doc = new HTMLDocumentHack(ss);
        doc.setParser(getParser());
        doc.setAsynchronousLoadPriority(4);
        doc.setTokenThreshold(100);
        return doc;
    }
}