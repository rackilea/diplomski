public static void main(String[] args) {
        int i;
        int number = 0;
        int numberCount = 8;
        int[] numberArray = new int[numberCount];
        double total = 0;
        double average = 0;
        int aboveAverage = 0;
        Scanner read = new Scanner (System.in);

        for(i = 0; i < numberCount; i++){
            System.out.print("Enter number " + (i + 1) + ": ");
            number = read.nextInt();
            if(number < 0){
                System.out.println("Invalid input");
                continue;
            }

            numberArray[i] = number;
            total += number;
        }
        average = total / numberCount;

        for(i = 0; i < numberCount; i++){
            if(numberArray[i] > average) {
                aboveAverage++;
            }
        }
        System.out.println("Count of numbers greater than average: " + aboveAverage);
        System.out.println("Print total: " + total);
        System.out.println("Print average: " + average);
}