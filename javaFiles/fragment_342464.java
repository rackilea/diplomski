import java.util.*;
import java.io.*; 
import javax.swing.JOptionPane;

public class ticketjava
{ 
    public static void main(String[] args) throws FileNotFoundException 
    {

        Scanner inFile = new Scanner(new FileReader("C:\\TicketGoals.txt"));

        double minimumAmount; 
        double goodAmount;

        minimumAmount = inFile.nextDouble();
        goodAmount = inFile.nextDouble();

        String yourTickets;

        yourTickets = JOptionPane.showInputDialog("Enter your tickets sold:");

        //you need to convert the String to a double
        //this will make it comparable with ">" in the below if statement
        double converted_yourTickets = Double.parseDouble(yourTickets);

        //added if/else
        //if condition A is true then do the follow...else do something different
        if (converted_yourTickets > minimumAmount){
            JOptionPane.showInputDialog(null, "Well done you have sold enough tickets",  JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showInputDialog(null, "You should really of sold more tickets",  JOptionPane.INFORMATION_MESSAGE);
        }

        //close the file before doing system.exit(0)
        inFile.close();
        //but im not sure why you have it in the first place...
            //System.exit(0);

    }

}