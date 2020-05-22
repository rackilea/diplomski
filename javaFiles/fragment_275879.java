import java.util.Scanner;
 public class avgFinder {
   public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     System.out.println("Input numbers to average. Separate by a space.");
     String nums = scan.nextLine();
     String[] parseNums = nums.split(" ");
     double sum = 0;
     int cnt = 0;
     for (int a=0; a<=parseNums.length-1; a++) {
       sum += Double.parseDouble(parseNums[a]);
       cnt++;
     }
     double mean = sum/cnt;
     System.out.println("Mean: " + mean);
   }
}