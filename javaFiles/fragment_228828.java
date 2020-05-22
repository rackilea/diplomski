public static int getNumberOfBoxes(int userInput, int numberOfTotalBoxes) {
    int numberOfBoxes = userInput / numberOfTotalBoxes;
    if(userInput % numberOfTotalBoxes != 0)
        numberOfBoxes++;
    return numberOfBoxes;
}