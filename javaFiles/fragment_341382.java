void myOperation(String number) {
    int n;
    try { 
        n = Integer.parse(number);
    } catch (NumberFormatException e) {
        n = DEFAULT;
    }
    doThings(n);
}