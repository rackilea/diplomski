import java.util.Scanner;
    public class isValid
    {
        static int accNum[] = {11111, 22222, 33333, 44444, 55555, 66666, 77777, 88888, 99999, 10101, 20202, 30303, 40404, 50505, 60606, 70707, 80808, 90909};

        public static void main(String[] args)
        {
            Scanner keyboard = new Scanner(System.in);

            int conti = -99;
            int search = 0;
            do
            {
                System.out.print("Enter 5-digit account number you want to validate: ");

                search = keyboard.nextInt();

                sequentialSearch(accNum, search);
                System.out.println("");
                System.out.print("Enter -9 to exit program, or any other number to validate another ID: ");
                conti = keyboard.nextInt();

        } while (conti != -9);
    }

    public static void sequentialSearch(int[] array,int value)
    {
        int index = 0;        
        int element = -1;      
        boolean found = false;    

        while (!found && index < array.length)
        {
            if (array[index] == value)
            {
                found = true;
                element = index;
                break; //prevent index addition if value found
            }
            index++;
        }

        if (found)
        {
            System.out.println("Account " + value + " is valid.");
        }
        else 
        {
            System.out.println("Account " + value + " is invalid.");
        }
    }
  }