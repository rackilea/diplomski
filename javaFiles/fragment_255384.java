String[] words=title.split(" ");
    String printWord = "";
    for (int i = 0; i < words.length; i++) {
        printWord += words[i] + " "; // Add the space for newly appended words
        System.out.println(printWord);
    }