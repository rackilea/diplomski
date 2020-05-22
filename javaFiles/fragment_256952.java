int counter;
int counter2 = 0 ;

for (int i = 1 ; i <= number ; i++) {

    //Resets the counter
    counter = 0 ;

    for (int j = 1 ; j <= i ; j++) {
        if (i % j == 0 ) {
            counter ++ ;
        }
        else if (i%j != 0) {
        }
    }

    //You don't need two if's if one is the negation of the other
    if (counter != 2) {
        System.out.println( i+" is not prime") ;
    }
    else{
        System.out.println(i+", is a prime") ;
    }
    System.out.println("\n") ;
    if (number % i == 0) {
        counter2 ++ ;
    }
}
//You don't need two if's if one is the negation of the other
if (counter2 != 2) {
    System.out.println( number+" is not prime") ;
}
else{
    System.out.println( number+" is a prime") ;
}