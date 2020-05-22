import java.util.Scanner;
public class apple {
   public static void main(String args []) {

     Scanner dic = new Scanner(System.in);    
     System.out.println("type the rate: "); 

     for (double ind=dic.nextDouble(); ind <=0.50; ind+=0.1){        
     // include my variables        
        if (ind == 0.2){        
          System.out.println("Group A has been Warned");  
          break;  
        }
        else if (ind == 0.3){        
          System.out.println("Group A and B need to shut down");  
          break;  
        }
         else if (ind == 0.4){        
           System.out.println("All Groups (A, B and C) need to shut down"); 
           break;   
         }
      }
   }
}