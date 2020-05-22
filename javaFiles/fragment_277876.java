if (getSelectedText() != null && getSelectedText().length()>0) {
        try {
            String selectedText = getSelectedText()
            htmlDoc.remove(getSelectionStart(), this.getSelectedText().length());
            (new HTMLEditorKit()).insertHTML(htmlDoc, pos, "<span id='myId'>"+selectedText+"</span>", 0, 0, Tag.SPAN);
        } catch (BadLocationException ex) {
            Logger.getLogger(Editeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }