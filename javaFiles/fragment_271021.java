int counter = 0;

    do
    {
        counter++;

        int IntRead = Reader.nextInt();
        System.out.println(IsPrimeNumber(IntRead));
    }
    while(counter < 10);