public static int readStartReading(){ 
int reading = 0;
Scanner keyboard = new Scanner(System.in);
boolean problemFlag = false;
for(;reading < 0 || problemFlag;)
{
    problemFlag = false;
    try {
        System.out.print("Enter the meter reading at the beginning of the year: ");
        String input = keyboard.nextLine();
        reading = Integer.parseInt(input);// 7. Assign a value to reading through the input device
    } catch (NumberFormatException x){
        problemFlag = true;
        System.out.println("You have to enter a number.");
    } if (reading < 0){
        System.out.println("The beginning meter reading cannot be negative."); }
}
return reading;
}