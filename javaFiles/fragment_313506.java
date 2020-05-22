public String addWord(String word, String definition) {
        if (dictionary.containsKey(word.toLowerCase())) {
            return "This word is already in the dictionary, "
                    + "please use the update function.";
        } else {
            dictionary.put(word.toLowerCase(), definition);
            return "Added";
        }
    }

    public String getDefiniton(String word) {
        if (dictionary.containsKey(word.toLowerCase())) {
            return dictionary.get(word.toLowerCase());

        } else {
            return "This word is not in the dictionary, "
                    + "please use the add function.";
        }
    }