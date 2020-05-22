public static int recursion(int inNumber) {
    //base case
    if (!(inNumber <= -10 || inNumber >= 10)) {
        return 1;
    //recursive case
    } else {
        return recursion(inNumber / 10) + 1;
    }
}