import java.util.*;
import java.io.*;

public class Student
{

    public static void main(String[] args)
    {

        int choiceentry;
        Scanner input = new Scanner(System.in);

        choiceentry = Enroll.menu(); //Access through the Enroll class
        if(choiceentry == 6)
        {
             //Exit if user entered 6
             System.exit(0);
        }

          while (true) //I hate to put while(true) in code, but it seems appropriate here
          {
                boolean hasAnswered = false; //use a flag to determine if the user entered a valid command
                if(choiceentry == 1) 
                {
                  hasAnswered = true;
                // ..do something
                }
                else if(choiceentry == 2)
                { 
                  hasAnswered = true;
                //..something else
                }
                else if(choiceentry == 3)
                {
                  hasAnswered = true;
                //...something else
                }
                else if(choiceentry == 4)
                {
                  hasAnswered = true;
                // ..something else
                }
                else if(choiceentry == 5)
                {
                  hasAnswered = true;
                //..something else
                }
                else
                {
                  System.out.println("Enter \"1\", \"2\", \"3\", \"4\", \"5\" or \"6\"");
                  choiceentry = input.nextInt(); //use the Scanner

                  if(choiceentry == 6)
                  {
                     //Exit if user entered 6
                     System.exit(0);
                  }
                }

                if (hasAnswered == true){
                    hasAnswered == false;
                    //user had issued a valid command, prompt for the next command
                    choiceentry = Enroll.menu(); //Access through the Enroll class
                    if(choiceentry == 6)
                    {
                       //Exit if user entered 6
                       System.exit(0);
                     }
                }
        }


    }
}