public void getNum1() {
    num1 = readInt("?:");
    if (num1 == 0) { // do not accept 0 for first number
        println("Please try again without 0.");
        getNum1();
    }
}

public void getNum2() {
     num2 = readInt("?:");
    if (num2 == 0) { // if 2nd number is 0, print 1st num as high and low nums
        println("Biggest number:" + num1);
        println("Smallest number:" + num1);
    }
}