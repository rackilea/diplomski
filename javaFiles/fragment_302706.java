int first = 0;
    int second = 1;
    int nextInSeq =first+second;
    int sum =0;

    while(nextInSeq < 4000000) {
        first = second;
        second = nextInSeq;
        nextInSeq = first + second;
        if(nextInSeq % 2 ==0)
            sum = sum + nextInSeq;
        System.out.println("Current Sum = " + sum);
    }
    System.out.println("Sum = " + sum);