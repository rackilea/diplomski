public class Squares{
   public static void main (String [] args){
      int counterA = 0;
      int counterB= 0;
      int one=0;
      int two=0;  

      while (counterA<51){
           counterA++;
           if (counterA % 5 == 0){
                one = (counterA*counterA);
           }               
      }
      while (counterB<101){
           counterB++;
           if (counterB % 2 == 0){
                two = (counterB*counterB);         
           }    
      }
       System.out.println(one+two);
   }
 }