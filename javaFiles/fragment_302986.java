String first = "hello world today";
    String second = "Yet another hello worldly day today";

    //split the second string into words
    List<String> wordsOfSecond = Arrays.asList(second.split(" "));

    //split and compare each word of the first string           
    for (String word : first.split(" ")) {
        if(wordsOfSecond.contains(word))
            System.out.println(word);
    }