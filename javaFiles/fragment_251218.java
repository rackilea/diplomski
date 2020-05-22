import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArrayIndexOutOfBoundException
{         
  public static void main(String [] args)
    throws IOException 
  {
    int num=0;
    int up=0;
    int down=0;
    int same=0;
    FileInputStream w = new FileInputStream("numbers.txt");
    Scanner scanner  = new Scanner(w);
    while(scanner.hasNextDouble())
    {
      Double [] con= new Double [15];
      for (int i=0; i<con.length; i++)
      {
        con[i]=scanner.nextDouble();
      }
      for (int a=0; a<con.length-1; a++)
      {
        num++;
        System.out.print(num+"  "+(con[a]));
        if(con[a]<con[a+1])
        {
           up++;
        }
        else if(con[a]>con[a+1])
        {    
          down++;
        }
        else
        {
          same++;
        }
        if ((up >= 3 && (down > 1 || same >= 1)))
        {  
          System.out.print("  "+"sell");
          up=0;
          same=0;
        }
        else if ((down >= 3 && (up > 1 || same >= 1)))
        {
          System.out.print("  "+"buy");
          down=0;
          same=0;
        } 
        System.out.println();
        if (a == con.length -2) {
            num++;
            System.out.print(num+"  "+(con[a]));
              if(con[con.length-2]<con[con.length-1])
              {
                 up++;
              }
              else if(con[con.length-2]>con[con.length-1])
              {    
                down++;
              }
              else
              {
                same++;
              }
              if ((up >= 3 && (down > 1 || same >= 1)))
              {  
                System.out.print("  "+"sell");
                up=0;
                same=0;
              }
              else if ((down >= 3 && (up > 1 || same >= 1)))
              {
                System.out.print("  "+"buy");
                down=0;
                same=0;
              } 
              System.out.println();
        }

      }
    }
    scanner.close();
  }
}