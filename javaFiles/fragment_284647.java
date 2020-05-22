public static String replaceChar(String word, char c, int i){
    if(0 < i && i < word.length()){
        return word.substring(0, i) + c + word.substring(i + 1);
    }
    return word;
}