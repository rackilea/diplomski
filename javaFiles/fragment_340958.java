while(fileWords.hasNextLine()) {
    StringBuilder sb = new StringBuilder();
    String[] wordsArr = fileWords.nextLine().split("\\s+");
    for(String str: wordsArr) {
        sb.insert(0, str).insert(str.length(), " ");
    }
    words.add(sb.toString());

}
Collections.reverse(words);
words.forEach(System.out::println);