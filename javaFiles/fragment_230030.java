for(int row = 1; row <= resultCard.length; row++) {
    lowest = resultCard[row][1];

    for(int s = 1; s < resultCard[0].length; s++) {
        tempInt = Integer.parseInt(resultCard[row][s]);
        if(lowest > tempInt) lowest = tempInt;
    }

    System.out.println("The Lowest Mark For " + resultCard[row][0] + " Is: " + lowest);
}