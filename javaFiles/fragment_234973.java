public static String createAnagram(String inputString) {
        String[] arr = inputString.split(" ");
        return Stream.of(arr)
                .map(AnagramsMaker::reverseWord)
                .collect(Collectors.joining(" "));
    }