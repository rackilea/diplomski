int halfLength = word.length / 2;
String firstHalf = word.substring(0, halfLength);
String secondHalf = word.substring(halfLength, word.length);
if (firstHalf.equals(secondHalf.reverse()) {
    //they match
}