import java.io.*;
import java.util.*;


/**
 * @author jyotiv
 *
 */
public class BinaryConversion{

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=0,countOne=0,maxCount = 0;
        String binaryNo="";
        int sum=0;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        binaryNo=Integer.toBinaryString(n);
        System.out.println(binaryNo);
        char binaryArray[]=binaryNo.toCharArray();
        for(int i=0;i<binaryArray.length;i++)
        {       
            //System.out.print(binaryArray[i]);

            if(binaryArray[i]=='1')
            {
                countOne++; 
            //}
            }
            if(countOne>maxCount)
            {
                maxCount=countOne;
            }
            if(binaryArray[i]=='0')
            {
                countOne=0;
            }
        }
        System.out.println(maxCount);
    }

}