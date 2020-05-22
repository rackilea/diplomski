private String obenglobish (String word) {
    String result = "";
    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (isEnglishVowel(c)) {
            if (c == 'e' && i == word.length()-1) {
                result += c;
            } else {
                if(i!=0 && isEnglishVowel(word.charAt(i-1))) {
                    result += c;
                } else {
                    result = result + "ob" + c;
                }                   
            }
        } else {
            result += c;
        } 
    }
    return result;
}