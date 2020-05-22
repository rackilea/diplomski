BigInteger first, second, third ;


first= new BigInteger("123");
    second= new BigInteger("50");

 for ( int i = 1; i <= 100 ; i++){

        third = first.add(second);           
        first = second;
        second = third;