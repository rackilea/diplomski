int[] generatedNumbers = new int[3];
    for(int i=0; i < 3; i++){
        int lotteryNumberDigit = (int)(Math.random()*10);
                    generatedNumbers[i] = lotteryNumberDigit;
        System.out.print(lotteryNumberDigit);
    }
    System.out.println();