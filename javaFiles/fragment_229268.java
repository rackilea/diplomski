public static boolean ascending(String word){
    if(word == null || word.length <2) return false;
    int i = 0;
    boolean ascend = false;
    while(i < word.length()-1){
        if (word.charAt(i) <= word.charAt(i+1))
            ascend = true;
        else{
            ascend = false;
            break;
        }
        i++;
    }    
    return (ascend);
 }