public static String removeBetween(String inputString, String startString, String endString) {
    int startIndex = inputString.indexOf(startString);
    int endIndex = inputString.indexOf(endString, startIndex + 1) + endString.length();
    String resultString;
    if (startIndex == 0) {
        resultString = inputString.substring(endIndex+1);
    }
    else {
        String a =  inputString.substring(0 , startIndex - 1);
        String b =  inputString.substring(endIndex).trim();
        resultString = a + b;
    }
    return resultString;
}