public static void main(String[] args) {
    int fibA = 0;
    int fibB = 1;
    int fibC = 0;
    int total = 0;

    while (true) { 
        fibC = fibA + fibB;  
        fibA = fibB;
        fibB = fibC;
        if (fibC >= MAX_TERM_VALUE){
             break;
        }
        if (fibC %2 == 0) {
            total = total + fibC; 
        }
    } 
    System.out.println(total);  
}

private static final int MAX_TERM_VALUE = 4000000;