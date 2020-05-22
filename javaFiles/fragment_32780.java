public String removeContractions(String inputString) { 

    inputString = inputString.replaceAll("n't", " not");
    inputString = inputString.replaceAll("'re", " are");
    inputString = inputString.replaceAll("'m", " am");
    inputString = inputString.replaceAll("'ll", " will");
    inputString = inputString.replaceAll("'ve", " have");

    return inputString;
}