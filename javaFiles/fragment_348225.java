System.out.println(" *** Game 1 *** ");
    int sum1=0;
    int sum2=0;
    int rollNumber = 1;
    System.out.println("Roll\tPlayer 1\tPlayer 2");
    while (sum1 < 21 && sum2 < 21){
         int roll1 = rand.nextInt(6) + 1;
         int roll2 = rand.nextInt(6) + 1;

         sum1 += roll1;
         sum2 += roll2;

         if (sum1 > 21) sum1 = 21;
         if (sum2 > 21) sum2 = 21;

         System.out.format("%d\t%d\t%d%n", rollNumber++, sum1, sum2);
    }

    if(sum1>sum2){

         System.out.println("player 1 wins");
    }
    else if(sum1<sum2){
         System.out.println("player 2 wins");
    }

    }