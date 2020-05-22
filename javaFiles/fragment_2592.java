public boolean curse(String str){
    //Create your set here
   HashSet<String> wordSet = new HashSet<String>();

    //Use it's add function to add your curse words
    wordSet.add("ass");

    String array[] = str.split(" ");

    for(String s : array){
        if(wordSet.contains(s.toLowerCase()))
            return true;
    }

    return false;
 }