public static ArrayList<String> getWords(String s){
ArrayList<String> words = new ArrayList<String>();
for(int i=0;i<s.length(); i=i+3){
    words.add(s.substring(i, Math.min(i + 3, i.length())));
}
return words;