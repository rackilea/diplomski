import java.util.Scanner;
   public class es04 {
   public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
   int n ;
   int count=0, total=0 ;
   int even;


  while (count < 5) {

             System.out.print("insert number:    ");
             n = scan.nextInt();
             if(n%2==0)
             {
             total=total+n;  count++;
             }
  }
      System.out.println("sum even numbers"+total);
 }
}