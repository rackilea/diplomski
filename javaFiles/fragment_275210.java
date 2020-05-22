String word1 = "Simple sentence that is first";
String word2 = "Another sentence that is second.";
appear(word1, word2);
}
static void appear(String word1, String word2){
    String[] split = word1.split(" ");
    String[] split2 = word2.split(" ");
    boolean appeared;
    for (int i = 0; i <= split.length - 1; i++){
        appeared = false;
        for (int j = 0; j <= split2.length - 1; j++){
            if (split[i].equals(split2[j])){
                appeared = true;
            }
        }
    if(appeared == false)
        System.out.println(split[i]);
    }
}