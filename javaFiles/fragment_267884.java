import javax.swing.JOptionPane;

    public class ArrayOperations
    {
       public static void main(String[] args)
       {

          String numbers;
          numbers = JOptionPane.showInputDialog("Enter your numbers: ");


           int count = 0;
             for(int i = 0; i < numbers.length(); i++) {
                  if(Character.isWhitespace(numbers.charAt(i))) count++;
             }

             int [] numbers1 = new int [++count];

                for(int n = 0; n < count; n++) {                    
                    numbers1[n] = Integer.parseInt(numbers.split(" ")[n]);
            }


      JOptionPane.showMessageDialog(null, "The sum of your numbers is: "
          + getTotal(numbers1) + "\nThe average of your numbers is: " + getAverage(numbers1)
          + "\nThe highest number was: " + getHighest(numbers1) + "\nThe lowest number "
          + "was: " + getLowest(numbers1)); 
       }
       public static double getTotal(int[] numbers1)
       {
          //Accumulate sum of elements in numbers1 array and return total 
          double total = 0.0;
          for (int index = 0; index < numbers1.length; index++)
             total += numbers1[index];

          return total;
       }
       public static double getAverage(int[] numbers1)
       {
          //Get average
          return (getTotal(numbers1) / numbers1.length);
       }   
       public static double getHighest(int[] numbers1)
       {
          //Find highest number entered
          double highest = numbers1[0];
          for (int index = 1; index < numbers1.length; index++)
          {
             if (numbers1[index] > highest)
                highest = numbers1[index];
          }
          return highest;
       }

       public static double getLowest(int[] numbers1)
       {
          //Find lowest number entered
          double lowest = numbers1[0];
          for (int index = 1; index < numbers1.length; index++)
          {
             if (numbers1[index] < lowest)
                lowest = numbers1[index];
          }
          return lowest;
       }
    }