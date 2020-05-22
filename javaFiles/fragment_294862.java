int number = -1, max = 0, count = 1;
Scanner input = new Scanner(System.in);
int askedCount = 0;

while(true){
    System.out.print("Enter an integer <0 ends the input>: ");
    number = input.nextInt();
    askedCount++;

    if (number == 0) {
        break;
    }

    if (number > max){
        max = number;
    } else if(number == max){
        count++;
    } 
}

if (askedCount <= 1) {
    System.out.println("No numbers are entered except 0");
} else {
    System.out.println("The maximum number is " + max);
    System.out.println("The count for the max number is " + count);
}