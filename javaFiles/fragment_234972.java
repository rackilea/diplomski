public static String createAnagram(String inputString) {
        String anagram = "";
        String [] arr = inputString.split(" ");

        for (String s : arr) {
            anagram += reverseWord(s) + " ";
        }
        return anagram.trim();
    }