for (String userInput : message.split(" ")) {
            if (legalEnglishWords.containsKey(userInput)) {
                System.out.println("\"" + userInput + "\" is an English word ");
                legalEnglishWords.put(userInput, legalEnglishWords.get(userInput) + 1);
            }
        }

        System.out.println("");

        for (String word : legalEnglishWords.keySet()) {
            System.out.println("the word \"" + word + "\" occurred " + legalEnglishWords.get(word) + " times");
        }