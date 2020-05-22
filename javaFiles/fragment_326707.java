import java.util.Scanner;

public class DogYears
{

   public static void main(String[] args)
   {

      Scanner scan = new Scanner(System.in);

      System.out.println("Enter your dog's age in human years. ");

      int age = scan.nextInt();

      for(int i = 0; i < 10000; i++)
      {



         int dogAge = age * 7;
         System.out.println("Your dog is " + age + " in human years and " + dogAge 
            + " in dog years!");

      //       scan.close();   <--- don't close it, you want to be able to do it again, right??

         if(dogAge>=150)
         {

            System.out.println("Likely story");

         }

         else if(dogAge>=80 && dogAge<150)
         {

            System.out.println("Hello grand-dog");

         }

         else if(dogAge>=40 && dogAge<80)
         {

            System.out.println("Boring!");

         }

         else if(dogAge>=20 && dogAge<40)
         {

            System.out.println("Get a job!");

         }

         else if(dogAge<20)
         {

            System.out.println("Just a pup!");

         }

         System.out.print("Enter your dog's age in human years. (Enter a negative number to stop the program)\n");

         String response = scan.next();

         age = Integer.parseInt(response);

         if(age < 0)
         {

            i = 10001;

         }




      }

   }


}