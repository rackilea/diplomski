public static int flipOpp(int num) {
    int reversed = 0;

    while (num!=0) {
        reversed = reversed*10 + num%10; 
        num /= 10;   
    } 
    return reversed;
}