@Override
public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) 
                throws BadLocationException {
    String regExp;
    Document doc = fb.getDocument();
    if(doc.getText(0, doc.getLength()).indexOf(".") == -1){
        regExp = "[^0-9.]";
    } else {
        regExp = "[^0-9]";
    }
    fb.insertString(off, str.replaceAll(regExp, ""), attr);
}

@Override
public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr) 
                throws BadLocationException {
    String regExp;
    Document doc = fb.getDocument();
    if(doc.getText(0, doc.getLength()).indexOf(".") == -1){
        regExp = "[^0-9.]";
    } else {
        regExp = "[^0-9]";
    }
    fb.replace(off, len, str.replaceAll(regExp, ""), attr);
}