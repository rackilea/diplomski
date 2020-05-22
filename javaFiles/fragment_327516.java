for ( int roll = 1; roll <=36000; roll++ ) {
    dice1 = 1 + randomNumbers.nextInt ( 6 );
    dice2 = 1 + randomNumbers.nextInt ( 6 );
    total = dice1+dice2;
    ++array[total];
}