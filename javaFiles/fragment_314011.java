import java.util.Scanner;
import java.text.DecimalFormat;

public class Election
{
    public static void main (String[] args)
    {

        DecimalFormat f = new DecimalFormat("##.00");
        DecimalFormat n = new DecimalFormat("##");

        float votesForPolly; 
        float votesForErnest; 
        float totalPolly = 0; 
        float totalErnest = 0; 
        String response;
        int precinctsforpolly = 0; 
        int precinctsforernest = 0;
        int precinctsties = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println ();      
        System.out.println ("Election Day Vote Counting Program");
        System.out.println ();

        do
        {   
            //point A
            System.out.println("Do you wish to enter more votes? Enter y:n");
            response = scan.next();
            if (response.equals("y"))
            {
                //point B
                System.out.println("Enter votes for Polly:");
                votesForPolly = scan.nextInt();
                System.out.println("Enter votes for Ernest:");
                votesForErnest = scan.nextInt();

                totalPolly = totalPolly + votesForPolly;
                totalErnest = totalErnest +  votesForErnest;


                    System.out.println("Do you wish to add precincts? Enter y:n");
                    String response2 = scan.next();//create a new response variable, so the loop doesn't confuse which response to break on
                    //I removed the inner loop. If you really intended for this to be an inner loop then the while(response2.equals("y")){} should be around the question, not after
                    if (response2.equals("y"))
                    {   
                        System.out.println("How many precincts voted for Polly: ");
                        precinctsforpolly = scan.nextInt();
                        System.out.println("How many precincts votes for Ernest: ");
                        precinctsforernest = scan.nextInt();
                        System.out.println("How many were ties: ");
                        precinctsties = scan.nextInt(); 

                    }
                //removed the unnecessary checks for when response in 'n'
            }
        }
        while (response.equals("y"));
        System.out.println("Final Tally");
        System.out.println("Polly received:\t " + n.format(totalPolly) + " votes\t" + f.format((totalPolly/(totalPolly + totalErnest))*100) + "%\t" + precinctsforpolly + " precincts");
        System.out.println("Ernest received: " + n.format(totalErnest) + " votes\t" + f.format((totalErnest/(totalPolly + totalErnest))*100) + "%\t" + precinctsforernest + " precincts");
        System.out.println("\t\t\t\t\t" + precinctsties + " precincts tied");

    }
}