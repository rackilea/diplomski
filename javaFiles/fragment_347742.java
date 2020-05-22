public static void main(String[] args) {

int smallest = Integer.MAX_VALUE;
int largest = 0;
int number;
double totalAvg = 0;
double totalSum = 0;
int count = 0;

Scanner kb = new Scanner(System.in);

System.out.println("Enter few integers (Enter negative numbers to end input) :");
while (true) { //LOOP till user enter "-1"
    number = kb.nextInt();

    //Condition for the loop to break
    if (number <= -1) {
        System.out.println("End Of Input");
        break;
    } else {
        count = count + 1;
    }

    if (number < smallest) { //Problem 1 : If 1st input num is bigger than 2nd input num,
        smallest = number;  // largest num will not be recorded..
    }

    //REMOVED ELSE ADDED another IF

    if (number > largest){
        largest = number;
    }

    totalSum = totalSum + number;
    totalAvg = (totalSum / count);

}

System.out.println("The smallest number you have entered is : " + smallest);
System.out.println("The largest number you have entered is : " + largest);
System.out.println("The total sum is : " + totalSum);
System.out.println("The total average is : " + totalAvg);
System.out.println("Count : " + count);
} // PSVM