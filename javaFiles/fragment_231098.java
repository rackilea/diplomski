int largestHeightInches = 0;
for( i = 1; i <= noOfPeople; index++ ) {
    currentHeightFeet = GetInt();
    currentHeightInches = GetInt();
    currentHeight = currentHeightInches + currrentHeightFeet * 12;

    if( largestHeightInches < currentHeight ) {
        largestHeightInches = currentHeight;
    }
}