public static ArrayList<String> allInv(String word) {
    ArrayList<String> ListMotsInverse = new ArrayList<String>();
    ListMotsInverse.add(word);
    StringBuilder newWord = new StringBuilder(word);
    for(int i = 0; i<word.length()-1; i++){
        char l = newWord.charAt(i);char r = newWord.charAt(i+1);
        newWord.setCharAt(i, r);
        newWord.setCharAt(i+1, l);
        System.out.println(newWord);
        ListMotsInverse.add(newWord.toString());

        //reset to original state
        newWord.setCharAt(i, l);
        newWord.setCharAt(i+1, r);
    }
    return ListMotsInverse;
}