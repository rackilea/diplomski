while ((s = br.readLine()) != null) {
    String[] lineWordList = s.split(" ");
    for (String word : lineWordList) {
        // JAVA 8
        keywordList.stream().filter(e -> word.contains(e)).findFirst()
                .ifPresent(e -> System.out.println(word));

        // JAVA <8
        for (String keyword : keywordList) {
            if (word.contains(keyword)) {
                System.out.println(s);
                break;
            }
        }
    }
}