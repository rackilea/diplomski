public static void main(String[] args) {
    int fibA = 0;
    int fibB = 1;
    int fibC = 0;
    int total = 0;

    while (fibC < MAX_TERM_VALUE) { //fibC is 89 and under MAX_TERM_VALUE = 100
        fibC = fibA + fibB; //fibC is 144 and more than MAX_TERM_VALUE 
        fibA = fibB;
        fibB = fibC;

        if (fibC %2 == 0) {
            total = total + fibC; //The fibC is added anyway as the check only happens next iteration
        }
    } 
    System.out.println(total);  
}
private static final int MAX_TERM_VALUE = 4000000;