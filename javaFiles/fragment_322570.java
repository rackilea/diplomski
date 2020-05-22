import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DOW {

  public static void main(String[] args) {
    File file = new File("/Users/***/RandomInts.txt");
    try {
      Scanner scanner = new Scanner(file);

      ArrayList<Integer>[] multiarray = new ArrayList[7]; // This is how one would make an array of ArrayList's.
      for (int i = 0; i < multiarray.length; i++)
        multiarray[i] = new ArrayList<Integer>();

      while (scanner.hasNextInt()) { //This is how you would save the values. You were saving temperatures incorrectly.
        int dow = scanner.nextInt() - 1; //Get day of week.
        int temp = scanner.nextInt(); //Get temperature. [Would throw exception here if your input was bad]
        multiarray[dow].add(temp); //Store temperature in the array representing the day of week.
      }

      // Looks like you want to find min, max and average in each column here.
      for (int x = 0; x < 7; x++) {
        int hightemp = Integer.MIN_VALUE; // Set this to something really low. (You will see why in a minute)
        int lowtemp = Integer.MAX_VALUE; // Set this to something really high.
        double avetemp = 0; // You seem to be using ave as "sum" right now and then you plan on dividing which is fine. This should also be a double.
        int size = multiarray[x].size(); // No point calling .size() [or in general any function] over and over again. Its better to just cache the answer.
        for (int y = 0; y < size; y++) {
          int num = multiarray[x].get(y); // Same logic as size here.
          hightemp = Math.max(hightemp, num);
          lowtemp = Math.min(lowtemp, num);
          avetemp += num;
        }
        avetemp = avetemp / size;
        // P.S.: Also you probably want to save the values of hightemp, lowtemp, avetemp somewhere after doing all this work!
        // Removed the rest of your code as it is irrelevant for your question.
      }
      // Close your streams.
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      // This would happen if your input file is bad.
      e.printStackTrace();
    }
  }
}