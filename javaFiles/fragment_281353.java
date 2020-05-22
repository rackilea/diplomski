public static boolean oneNumeric(String s) {
    String[] digit = {"0","1", "2", "3", "4", "5", "6" ,"7", "8", "9"};
    for (int i=0; i< digit.length; i++) {
        if(s.contains(digit[i])) {
                return true;
        }
    }
    return false;    
}