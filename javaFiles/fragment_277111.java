public static int readStartReading()
{ 
int reading = 0;
Scanner keyboard; //remove first reading here

do
{
    try {
        System.out.print("Enter the meter reading at the beginning of the year: ");
        String input = keyboard.nextLine();
        reading = Integer.parseInt(input);// 7. Assign a value to reading through the input device

        //if control reaches here, you have a valid integer, test it
        if (reading < 0)
            System.out.println("The beginning meter reading cannot be negative.");

    } catch (NumberFormatException x){
        reading = -1; //set reading to a negative invalid value
        System.out.println("You have to enter a number.");
    }
} while(reading < 0)
return reading;
}