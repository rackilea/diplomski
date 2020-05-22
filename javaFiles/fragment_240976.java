import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class nameChoice
{
    public static ArrayList<String> formName()
    {
        ArrayList<String> formNames = new ArrayList<String>();
        formNames.add("Master");
        formNames.add("Sir");
        formNames.add("Mr Smith");
        return formNames;
    }

    public static ArrayList<String> nickName()
    {
        ArrayList<String> nickNames = new ArrayList<String>();
        nickNames.add("Ol' Fella");
        nickNames.add("Buddy");
        nickNames.add("Dude");
        nickNames.add("Mate");
        nickNames.add("John");
        return nickNames;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void main(String[] args)
    {
        boolean manners;
        ArrayList<String> myName;

        System.out.println("Do you want me to be formal?");
        Scanner formal = new Scanner(System.in);
        String formalInput = formal.next();

        if (formalInput.equals("yes") || formalInput.equals("yep"))
        {
            manners = true;
        }
        else
        {
            manners = false;
        }

        if (manners == true)
        {
            myName = formName();
        }
        else
        {
            myName = nickName();
        }

        System.out.println("Hello " + myName.get((randInt(0, (myName.size() - 1)))) + ", how are you?");
    }
}