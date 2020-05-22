import java.util.*;
class ExamTesterNine{
public static void main(String args[]){
Scanner kbReader= new Scanner(System.in);
int num = 0;
System.out.println("Enter an integer smaller than 20 and larger than 0");
  do{
     num=kbReader.nextInt();
   } while(num<0 && num <20);

   int result;
   int sum=0;

   for(int i=1; i<=num; i++)
   sum=sum+i;

   int [] number= new int [num];
   for (int a=0; a<(number.length-1); a++ ){
     number[a]=a+1;
     System.out.print(number[a]+"+");}
   System.out.print(num+"="+sum);
   }

  }
}