public static boolean containsNonLetter(String s){
    for(int i = 0; i < s.length(); i++){
        int ind = (int)s.charAt(i);
        if(ind < 65 || (ind > 90 && ind < 97) || ind > 122)
            return true;
    }
    return false;
}