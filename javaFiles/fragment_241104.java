public static boolean checkDigit(String s) {
    char[] c = s.toCharArray();

    for(int i=0; i < c.length-1; i++) {
        if(Character.isDigit(c[i]) && Character.isDigit(c[i+1])) {
            return true;
        }
    }

    return false;
 }