public static int recursion(int inNumber) {
    //create a counter variable for the total of digits
    int totalDigits = 0;
    //base case
    if (!(inNumber <= -10 || inNumber >= 10)) { //notice the !
        return totalDigits + 1;
    //recursive case
    } else {
        totalDigits++;
        return recursion(inNumber / 10) + totalDigits;
    }
}