public static void main(String[] args) {

    String list = "word,another,word2"; //No need for () here
    String[] wordArr = list.split(",");
    Set<String> mySet = new TreeSet<String>(Arrays.asList(wordArr));

    for(String s:mySet){
        System.out.println(s);
    }

}