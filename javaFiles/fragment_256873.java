import java.util.Scanner;
public class Example 
{
    public static void main(String[] args)
    {
       boolean isNumber = false; 
       String phoneNum = "";
       Scanner input = new Scanner(System.in); 

       while(!isNumber)
       {
            isNumber = true;
            System.out.print("\nEnter your 10 digit phone number (ex: 4142317534): ");
            phoneNum = input.nextLine();

            for(int i = 0; i < phoneNum.length(); i++)
            {
               if(!Character.isDigit(phoneNum.charAt(i)))
               {
                  isNumber = false;
               }
            }


            if(phoneNum.length() != 10)
            {
              isNumber = false;
            }


            if(isNumber == false)
            {
               System.out.println("\n\nInvalid format - please reenter");
            }
       }

       System.out.println("\n\nPhone Number: " + phoneNum);

    }


}