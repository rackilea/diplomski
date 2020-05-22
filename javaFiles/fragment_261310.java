StringBuilder stringOfWords=new StringBuilder();
    for (String word : words) {
        // Check if it contains the character
        if (word.contains(Character.toString(character))) {
            stringOfWords.append(word+" ");
        }

    }
    //2.check is to be put after the loop
    if (stringOfWords.length() > 0) {
        System.out.println("Words containing the letter " + character
                + " : " + stringOfWords);
    } else {
        System.out.println("Character is not in any word");
    }