input = input.trim();

    int firstSpace = input.indexOf(" ");
    int lastSpace = input.lastIndexOf(" ");

    String firstWord = input.substring(0, firstSpace);
    String middlePhrase = input.substring(firstSpace + 1, lastSpace);
    String lastWord = input.substring(lastSpace + 1);

    if (!lastWord.isEmpty() {
        lastWord = lastWord.substring(0, 1).toUpperCase() + lastWord.substring(1);
    }

    System.out.println(lastWord + " " + middlePhrase + " " + firstWord);