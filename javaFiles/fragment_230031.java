static String[][] resultCard;
int average(int collumn) {
    if(collumn > resultCard.length) return 0;

    int average;
    for(int i = 1; i < resultCard[collumn].length; i++)
       average += Integer.parseInt(resultCard[collumn][i]);
    return average / resultCard[collumn].length;
}