import java.io.*;
class p6
 {
  InputStreamReader i1 =new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(i1);  
// calculating the CI and SI
public void calc()throws IOException
{   double p,t,r, a, si, ci;char k;//Changed all to double.
    do
    {
      // getting principle
      System.out.println("Enter Principle in decimal:");           
      p = Double.parseDouble(br.readLine());// changed to Double.parseDouble to store double value.
      // getting Rate
      System.out.println("Enter Rate in decimal    :"); 
      r = Double.parseDouble(br.readLine());// changed to Double.parseDouble to store double value.
      // getting Time
      System.out.println("Enter Time               :"); 
      t = Double.parseDouble(br.readLine());// changed to Double.parseDouble to store double value.
      //calculating SI
      si = (p*t*r)/100;
      // calculating amount
      a = (double)p*(Math.pow((1+r/100),t));  
      // calculating CI
      ci = a - p;
      // printing Difference
      System.out.println("Difference between CI and SI = "+(ci-si)); 

     }while(t!=0);//end of DOWhile
  }// end of calc
}//end of p6