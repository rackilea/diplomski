ModifiedHTMLDocument doc = (ModifiedHTMLDocument) editor.getDocument();
int offset = editor.getSelectionStart();
//insert our special tag (if the tag is not bounded with non-whitespace character, nothing happens)
doc.insertHTML(offset, "-<specialTag />-");
//remove leading and trailing minuses
doc.remove(offset, 1); //at the current position is the minus before tag inserted
doc.remove(offset + 1, 1); //the next sign is minus after new tag (the tag is nowhere)
//Note: no, you really cannot do that: doc.remove(offset, 2), because then the tag is deleted