public boolean validate(String val) {
    int len=val.length();

    if(len>=8) {
        boolean alp=false,dgt=false;
        for(int xa=0; xa<len; xa++) {
            char chr=val.charAt(xa);
            alp|=Character.isLetter(chr);
            dgt|=Character.isDigit (chr);
            if(alp && dgt) { return true; }
            }
        }
    return false;
    }