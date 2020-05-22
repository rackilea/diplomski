public void appendTextPane (String html) {
        HTMLEditorKit editor = (HTMLEditorKit) jTextPane.getEditorKit();
        HTMLDocument doc = (HTMLDocument) jTextPane.getDocument();
        String TAG;
        if (html.charAt(0) != '<') {
            TAG = "";
        } else {
            int nextSpaceIdx = html.indexOf(" ");
            int nextBrcktIdx = html.indexOf(">");
            TAG = html.substring(1, nextBrcktIdx < nextSpaceIdx ? nextBrcktIdx : nextSpaceIdx);
        }
//        System.out.println(jTextPane.getText());
        try {
            editor.insertHTML(doc, doc.getLength(), html.replaceAll(" ", "&#160;"), 0, 0, HTML.getTag(TAG));
        } catch (IOException | BadLocationException ex) {
        }
    }