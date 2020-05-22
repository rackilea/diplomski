System.out.print("Enter the test score: ");
while (!keyboard.hasNextInt()) {//Will run till an integer input is found
    System.out.println("Only number input is allowed!");
    System.out.print("Enter the test score: ");
    keyboard.next();
}
int tS = keyboard.nextInt();
//If input is a valid int value then the above while loop would not be executed   
//but it will be assigned to your variable 'int ts'
count++;

sum = (sum + tS);