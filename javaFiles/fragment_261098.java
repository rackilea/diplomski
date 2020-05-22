public  void  getWords(){
    String str = "I have not used no  water but the water not used by me and no sea not but water no!";
    String[] words = str.split(" +|\t+|!");//split by space, tab and exclamation mark

    int currentPos = 0;
    int len = words.length;
    List<String> matchedWords = new ArrayList<String>();
    for(int i=0;i<len;i++){
        if("no".equals(words[i])||"not".equals(words[i])){
            if(currentPos!=i-1&&i-1>=0)//so we leave out duplicate words
                matchedWords.add(words[i-1]);
            if(i+1<len-1)
                matchedWords.add(words[i+1]);//
            currentPos = i+1;
        }
    }

    for(String s : matchedWords)
        System.out.println(s);

}