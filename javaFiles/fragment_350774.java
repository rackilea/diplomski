public static void listPrimes(int maxNum) {
    System.out.println(2);
    for (int i = 3; i < maxNum; i += 2) {   
        int sqrtI = (int)Math.sqrt(i);
        int j;
        for (j = 2; j <= sqrtI; j++)
            if (i % j == 0)
                break;   

        if (j == sqrtI + 1)
            System.out.println(i); 
    } 
}