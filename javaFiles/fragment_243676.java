// The "MepzzGay" class.
import java.awt.*;
import hsa.Console;

public class C7Q4
{
    static Console c;           // The output console
    static char num1, num2, num3, num4, num5, num6, num7, num8, num9;
    static int dig1, dig2, dig3, dig4, dig5, dig6, dig7, dig8, dig9, sum1, sum2;
    static int sumOfS1 = 0, combinedSum, finalDigit;
    static String sinNum;
    public static void main (String[] args)
    {
        c = new Console ();
        input ();
        processing ();
        c.println ("");
        c.println ("");
        stepOne ();
        stepTwo ();
        c.println ("");
        c.println ("");
        stepThree ();
        c.println ("");
        c.println ("");
        stepFour ();
        c.println ("");
        c.println ("");
        stepFive ();
        // Place your program here.  'c' is the output console
    } // main method


    public static void input ()
    {
        c.println ("Hello!");
        c.println ("please enter your SIN number with no spaces");
        sinNum = c.readLine ();

    }


    public static void processing ()
    {
        String str = (sinNum);
        num1 = str.charAt (0);
        num2 = str.charAt (1);
        num3 = str.charAt (2);
        num4 = str.charAt (3);
        num5 = str.charAt (4);
        num6 = str.charAt (5);
        num7 = str.charAt (6);
        num8 = str.charAt (7);
        num9 = str.charAt (8);
        dig1 = Character.getNumericValue (num1);
        dig2 = Character.getNumericValue (num2);
        dig3 = Character.getNumericValue (num3);
        dig4 = Character.getNumericValue (num4);
        dig5 = Character.getNumericValue (num5);
        dig6 = Character.getNumericValue (num6);
        dig7 = Character.getNumericValue (num7);
        dig8 = Character.getNumericValue (num8);
        dig9 = Character.getNumericValue (num9);
    }


    public static void stepOne ()
    {
        dig2 = dig2 * 2;
        dig4 = dig4 * 2;
        dig6 = dig6 * 2;
        dig8 = dig8 * 2;
    }


    public static void stepTwo ()
    {
        String str = "" + dig2 + dig4 + dig6 + dig8;
        String numberOnly = str.replaceAll ("[^0-9]", "");

        try
        {
            sum1 = Integer.parseInt (numberOnly);
        }


        catch (NumberFormatException e)
        {
            sum1 = 0;
        }

        int numbers = sum1;
        while (numbers > 0)
        {
            sumOfS1 = sumOfS1 + numbers % 10;
            numbers = numbers / 10;
        }
        c.println ("Digits #2,4,6,8 multiplied by 2 then, all digits added together");
        c.println (sumOfS1);

    }


    public static void stepThree ()
    {
        sum2 = dig1 + dig3 + dig5 + dig7;
        c.println ("Digits #1,3,5,7");
        c.println (sum2);
    }


    public static void stepFour ()
    {
        combinedSum = sumOfS1 + sum2;
        c.println ("Sum of the two sums combined");
        c.println (combinedSum);
    }


    public static void stepFive ()
    {
        int roundUp = (int) (Math.ceil (combinedSum / 10) * 10);
        c.println ("("+combinedSum+"-"+roundUp+")*-1");

        finalDigit = combinedSum + roundUp * (-1);
        c.println (finalDigit);
        if (finalDigit == dig9)

            {
                c.println ("This is correct");
            }
        else if (finalDigit != dig9)
        {
            c.println ("This is incorrect");
        }
    }
} // MepzzGay class