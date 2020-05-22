public void openFile(String fileName) throws IOException {
    editor.setEditorKit(new ModifiedHTMLEditorKit());
    ModifiedHTMLDocument doc = (ModifiedHTMLDocument)editor.getDocument();
    try {
        editor.getEditorKit().read(new FileReader(fileName), doc, 0);
    }
    catch (BadLocationException b) {
        throw new IOException("Could not fill data into editor.", b);
    }
}