import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class CFEA{
  public static void main(String[] s){
    Scanner scan = new Scanner(System.in);
    byte testCases = Byte.parseByte(scan.nextLine());   //used byte for test cases instead of int
    for(int i = 0 ; i<testCases;++i){
     long sum = 0;
     //BigInteger big = new BigInteger("0");
     ArrayList<Integer> mySort = new ArrayList<Integer>();
     int n = Integer.parseInt(scan.nextLine());
     String input = scan.nextLine();
     String[] my = input.split(" ");
      for(String myString : my){
       mySort.add(Integer.parseInt(myString));
      }
     Collections.sort(mySort);
      for(int j = mySort.size()-1 ; j >= 0 ; j=j-2){
         sum += mySort.get(j);
      }
     System.out.println(sum);
    }
  }
}