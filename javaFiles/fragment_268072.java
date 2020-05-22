public static void main(String args[]){
    int index = 0;
    long fibterm = 0;
    while ((fibterm = fibonacci(index++)) < 4000000){
        System.out.println(fibterm);
    }
}