int[] textPositions = new int[savedInput.length()];

for (int i = 0; i < textParsed.size(); ++i) {
    String element = textParsed.get(i); 
    int readString = 0;

    int indexOfElement;

    while ((indexOfElement = savedInput.indexOf(element, readString)) > -1) {
        textPositions[indexOfElement] = i;
        readString = indexOfElement + element.length();
    }
}