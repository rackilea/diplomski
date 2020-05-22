package ov3uppgift8;
    import java.util.Scanner;
    import java.util.Random;

    public class Ov3uppgift8 {

        public static void main(String[] args) {
           Scanner input = new Scanner(System.in);
           Random rand = new Random ();

            System.out.println("*****************");
            System.out.println("* MATH TRAINING *");
            System.out.println("*****************");
            System.out.println("Enter 0 to close program.");
                int ans;
                do
                {    
                int a = rand.nextInt(10) + 1;
                int b = rand.nextInt(10) + 1;
                    System.out.print(a + " + " + b +" = ");
                ans = input.nextInt();    

                if (ans==(a+b))

                {
                    System.out.println("CORRECT!");
                }
                 else if (ans==0) 

                {
                    System.out.println("Good bye!");

                }

                else if (ans!=(a+b))

                {
                    // here you keep asking the user over and over 
                    //until they give the right result
                    do{
                        System.out.println("Incorrect, try again.");
                        //show again the equation to the user
                        System.out.print(a + " + " + b +" = ");
                        ans = input.nextInt();
                    }while(ans!=(a+b));
                }
                }
          while (ans!=0);     
        }

    }