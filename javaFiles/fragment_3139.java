@Override
public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
    //we want standard behavior if we are not placing space at start of JTextField
    //or if we are placing text at start of JTextField but first character is not whitespace
    if ( i!=0 || ( i==0 && !Character.isWhitespace(string.charAt(0)) ) ){
        super.replace(fb, i, i1, string, as);
    }else{
        System.out.println("no spaces allowed");
    }
}