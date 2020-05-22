public static String replaceIfOdd(String stringToChange,
        String searchingWord, String replacingWord) {
    final String separator = "#######";
    String splittingString = stringToChange.replaceAll(searchingWord,
            separator + searchingWord);
    String[] splitArray = splittingString.split(separator);
    String result = "";
    for (int i = 0; i < splitArray.length; i++) {
        if (i % 2 == 1)
            splitArray[i] = splitArray[i].replace(searchingWord,
                    replacingWord);
        result += splitArray[i];
    }
    System.out.println(result);
    return result;
}