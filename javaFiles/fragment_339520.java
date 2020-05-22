static String getGreyCode(int myNum, int numOfBits) {
    if (numOfBits == 1) {
        return String.valueOf(myNum);
    }

    if (myNum >= Math.pow(2, (numOfBits - 1))) {
        return "1" + getGreyCode((int)(Math.pow(2, (numOfBits))) - myNum - 1, numOfBits - 1);
    } else {
        return "0" + getGreyCode(myNum, numOfBits - 1);
    }
}

static String getGreyCode(int myNum) {

    //Use the minimal bits required to show this number
    int numOfBits = (int)(Math.log(myNum) / Math.log(2)) + 1;
    return getGreyCode(myNum, numOfBits);
}