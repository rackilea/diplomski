int incr = 0;
for(int i = 0; i <= number; i++){
    for(int j = 0; j < i; j++){
       System.out.print((incr++) * number2 + " ");
    }
    System.out.println("");
}