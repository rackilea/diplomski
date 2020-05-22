import javax.swing.*;
public class CarCareChoice
{
   public static void main(String[] args)
   {

      // ...

      for(int x = 0; x < NUM_OF_ITEMS; ++x)
      {
         if(careChoice.equals(validChoices[x]))
         {
             validChoice = true;
             choicePrice = prices[x];
         }
     }
     if(validChoice)
        JOptionPane.showMessageDialog(null, "The price of a " + careChoice + " is $" + choicePrice);
     else
        JOptionPane.showMessageDialog(null, "Sorry - invalid entry");

   }
}