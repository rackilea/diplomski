static String super_reduced_string(String s){
    for (int i = 0; i < s.length()-1; i++) {
        if (s.charAt(i) == s.charAt(i+1)) {
            s = s.substring(0, i) + s.substring(i+2);
            i = -1; // so after the ++ at the end of the loop, the next loop-run will have i==0.
        }
    }
    if (s.length() == 0) {
        return("Empty String");
    } else {
        return(s);
    }
}