import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class UserInput
{
    String fullName;
    String userId;
    ArrayList<String> qA = new ArrayList<String>();

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in); 

        while (true) {

           System.out.println("Please enter your Full Name: ");
           fullName = sc.nextLine();

           System.out.println("Please enter your ID: ");
           userId = sc.nextLine();

           System.out.println("What is your race/ethinicity? A. Hispanic/Latino, B. Asian, C. Caucasian, D. African American: ");
           qA.add(sc.nextLine());

           System.out.println("What is your preferred language? A. Spanish, B. English, C. Portugues, D. French: ");
           qA.add(sc.nextLine());

           System.out.println("What is your political affiliation? A. Republican, B. Democrat, C. Green, D. None: ");
           qA.add(sc.nextLine());

           System.out.println("What is your religious practice? A. Christian, B. Islam, C. Judaism, D. Hinduism: ");
           qA.add(sc.nextLine());

           System.out.println("What is your sexual orientation? A. Homosexual, B. Heterosexual, C. Bisexual, D. Asexual: ");
           qA.add(sc.nextLine());

           System.out.println("What is your favorite ice cream? A. Vanilla, B. Chocolate, C. Banana, D. Gum: ");
           qA.add(sc.nextLine());

           System.out.println("What is your favorite activity? A. Running, B. Walking, C. Sleeping, D. Eating: ");
           qA.add(sc.nextLine());

           System.out.println("What is your favorite color? A. Burgundy, B. Black, C. Gold, D. Blue: ");
           qA.add(sc.nextLine());

           System.out.println("What is your favorite clothing item? A. Shoes, B. Hats, C. Shirts, D. Rings: ");
           qA.add(sc.nextLine());

           System.out.println("What is your favorite pet? A. Dog, B. Cat, C. Tiger, D. Turtle: ");
           qA.add(sc.nextLine());

           Random random = new Random();

           for (int i =0; i < 1; i++) {
               int answerScore = random.nextInt(10) + 1;
               System.out.println("Test Score " + answerScore + "/10");
           }

           boolean youWantToWrite = true;
           if (youWantToWrite)
           {
               writeValuesToFile();
           }
        }
    }

    public static void writeValuesToFile()
    {
       java.io.File f = new java.io.File("FileName.txt");
        try (PrintWriter out = new PrintWriter(f);)
        {
            out.println(fullName);
            out.println(userId);
            for (String s : qA)
            {
                out.println(s);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}