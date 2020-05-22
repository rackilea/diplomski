public int countDistributionPoints() {
    // a whole bunch of stuff that doesn't use retVal

    //Variable to hold the number of distribution points.
    int retVal = 0;

    //If there is a suit with 3 cards or more, return 0 points.
    if ( c >=3 || d >= 3 || s >=3 || h >=3) {
        retVal = 0;
    }  
    //etc

    return retVal;
}