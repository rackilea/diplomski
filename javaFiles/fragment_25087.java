public void cut() {
    String selectedText = (String) webview.getEngine().executeScript(
            "editor.getSelection();");
    webview.getEngine().executeScript("editor.replaceSelection(\"\");");
    final Clipboard clipboard = Clipboard.getSystemClipboard();
    final ClipboardContent content = new ClipboardContent();
    content.putString(selectedText);
    clipboard.setContent(content);

}

public void copy() {
    String selectedText = (String) webview.getEngine().executeScript(
            "editor.getSelection();");
    final Clipboard clipboard = Clipboard.getSystemClipboard();
    final ClipboardContent content = new ClipboardContent();
    content.putString(selectedText);
    clipboard.setContent(content);
}

public void paste() {
    final Clipboard clipboard = Clipboard.getSystemClipboard();
    String content = (String) clipboard.getContent(DataFormat.PLAIN_TEXT);
    webview.getEngine().executeScript(String.format("editor.replaceSelection(\"%s\");", content));
}