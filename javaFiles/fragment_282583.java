public String reverse(String sentence) {
    String[] words = sentence.split(" ");
    String ret = "";
    for(int i = words.length - 1; i >= 0; i--) {
        ret += words + " ";
    }
    return ret;
}