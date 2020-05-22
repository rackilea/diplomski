import java.util.*;

public class CyclicShiftApp{

public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<Integer>();
    System.out.print("Enter integers please ");
    System.out.println("(EOF or non-integer to terminate): ");

    while(scan.hasNextInt()){
         list.add(scan.nextInt());
    }

    Integer [] nums = list.toArray(new Integer[0]);
    for(int i = 0; i < nums.length; i++){
       System.out.println(nums[i]);
    }
  }   
}