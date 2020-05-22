public static String functionalShiftLetters(String str){
    String ss = new String();
    for(int x = 0; x < str.length(); x++){
      ss += (char)((str.charAt(x) + 1)) + "";
    }
    return ss;
}