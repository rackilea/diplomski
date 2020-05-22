//If there is a suit with 3 cards or more, return 0 points.
if ( c >=3 || d >= 3 || s >=3 || h >=3) {
    retVal = 0;
}  
//If there is a suit with 2 cards, return 1 points.
else if ( c == 2 || d == 2 || s == 2 || h == 2) {
    retVal = 1;
} 
//If there is a suit with 1 card, return 2 points.
else if ( c == 1 || d == 1 || s == 1 || h == 1) {
    retVal = 2;
}     
//If there is a suit with 0 cards, return 3 points.
else {
    retVal = 3;
}