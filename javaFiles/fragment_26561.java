import java.io.*;
import java.util.Scanner;
public class test{

public static void main(String[] args)
{
    System.out.print("Enter number of tickets: ");
    Scanner numReader= new Scanner(System.in);
    int num = numReader.nextInt();
    System.out.println("Lottery Numbers: ");
    System.out.println();
    for(int i=0; i<num; i++)  
    {  
        int[] lottoNumber = getTicket();
        System.out.print(lottoNumber[0] + " " );
        System.out.print(lottoNumber[1] + " " );
        System.out.print(lottoNumber[2] + " " );
        System.out.print(lottoNumber[3] + " " );
        System.out.print(lottoNumber[4] + " " );
        System.out.print("MEGA:(" + lottoNumber[5] + ")");
        System.out.println();
    }  

}  
    public static int[] getTicket()
    {
        int[] lottoNumber = new int[6];
        {  
        lottoNumber[0] = (int) ((47 * Math.random()) + 1);  
        lottoNumber[1] = (int) ((47 * Math.random()) + 1);  
        lottoNumber[2] = (int) ((47 * Math.random()) + 1);  
        lottoNumber[3] = (int) ((47 * Math.random()) + 1);  
        lottoNumber[4] = (int) ((47 * Math.random()) + 1);  
        lottoNumber[5] = (int) ((27 * Math.random()) + 1);  
        }  
        return lottoNumber;
    }
}