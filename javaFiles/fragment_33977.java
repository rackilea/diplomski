public static boolean isSubstring(String string1, String substring) {
    char c[]=string1.toCharArray();
    char d[]=substring.toCharArray();

    for (int i = 0; i < c.length; i++) {
        if(c[i] == d[0]){
            boolean match = false;
            for(int j = 0; j < d.length; j++){
                if(c[i+j] != d[j]){
                    match = false;
                    break;
                } else{
                    match = true;
                }
            }

            if(match)   return true;
        }   
    }
    return false;
}