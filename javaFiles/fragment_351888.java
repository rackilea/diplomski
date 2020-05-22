public static void bruteForce(int num) {    //25
    double fact = num;

    // precision was lost on high i
    for (int i = num - 1; i > 1; i--)
        fact *= i;

    String str = String.format("%.0f", fact);   //15511210043330984000000000
    System.out.println(str);

    int i = str.length() - 1;
    int numOfZeroes = 0;

    while (str.charAt(i--) == '0')
        numOfZeroes++;

    System.out.println("Number of zeroes " + numOfZeroes);  //9
}