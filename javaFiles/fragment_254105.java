public String getMessage(int numEggs) {

    int a = numEggs / 12;
    int b = numEggs % 12;

    if (numEggs < 0) {
        return "Invalid number";
    } else {
        return "Your number of eggs is " + a + " dozen(s) and "
                + b + ".";          
    }
}