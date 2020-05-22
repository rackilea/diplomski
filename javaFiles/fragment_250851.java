String[] allLongestStrings(String[] inputArray) {

        int longest = 0;

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].length() > longest) {
                longest = inputArray[i].length();
            }
            for (int j = 0; j < inputArray.length; j++) {
                String word = inputArray[i];
                if (word.length() == longest)
                    list.add(word);
            }
        }
        String[] strings = list.stream().toArray(String[]::new);
        return strings;
    }