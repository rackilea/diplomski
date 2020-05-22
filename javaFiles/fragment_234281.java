public static void main(String[] ar) {
    int orig = 123456789;
    int lastDigit = 0;
    /* we'll use the copy of original number for step I & II
     * instead of messing with the original number
     */
    int numberWithoutLast = orig;
    String reversed = ""; // we'll use this to store every last digit
    for(int i = 0;
        i < Integer.toString(orig).length(); /* this will repeat the loop for number of digits in "orig" */
        i++) {
        lastDigit = numberWithoutLast % 10;
        reversed += Integer.toString(lastDigit);
        numberWithoutLast = numberWithoutLast / 10;
    }
    // lastly we print the reversed number
    System.out.println("Reversed Number: " + reversed);
}