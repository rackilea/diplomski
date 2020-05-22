public String removeControversialContractions(String inputString) {

    inputString = inputString.replaceAll("'d", " would");
    inputString = inputString.replaceAll("'s", "s");

    return inputString;
}