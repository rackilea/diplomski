String makeStrings() {
    String s = "HI";           //String literal
    s = s + "5";               //concatenation creates new String object (1)
    s = s.substring(0,1);      //creates new String object (2)
    s = s.toLowerCase();       //creates new String object (3)
    return s.toString();       //returns already defined String
}