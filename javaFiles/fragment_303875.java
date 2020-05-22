public static void main(String [] args)
 {
    int [] randomNums = new int [100];
    for (int i = 0; i < randomNums.length; i++) { 
        randomNums[i] = (int) (Math.random() * 26); 
    }
        int[] oddNums = sortOdd(randomNums);
        System.out.println("The odd numbers are "); 
        for (int n = 0; n<oddNums.length; n++) { 
        System.out.print(oddNums[n] + "  " ); 

    }
        int[] evenNums = sortEven(randomNums);
        System.out.println("The even numbers are ");
        for (int o = 0; o<evenNums.length; o++) { 
        System.out.print(evenNums[o] + "  "); 
        } 
}