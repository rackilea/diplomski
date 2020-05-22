if (isValidInput(input)) {
    String first3 = input.substring(0, 3);
    for (String word : vocabularyList) {
        if (word.startsWith(first3)) {
            System.out.println(word);
        }
    }
}