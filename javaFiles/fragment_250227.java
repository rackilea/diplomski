public static void displayDigits(int num1) {
    String result = "";
    for (int i=0; num1>0; i++) {
        if(i>0) result = " " + result;
        result = num1%10 + result;
        num1 /= 10;
    }
    System.out.println(result);
}