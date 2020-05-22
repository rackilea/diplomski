private static void reverseWords(String str) {
    // TODO Auto-generated method stub
    String[] words = str.split("\\s");
    String reverse = "";
    int len = words.length;

    for(int i=0;i<len;i++){
        reverse = reverse+new StringBuilder(words[i]).reverse().toString();
        if(i<len-1){
            reverse = reverse+" ";
        }
    }

    System.out.println(str);
    System.out.println(reverse);
}