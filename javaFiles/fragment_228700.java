//Use concrete imports! 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {

public static void main(String args[])
{
//You only need one scanner
Scanner sc = new Scanner(System.in);
try
{
    FileOutputStream fout = new FileOutputStream("file4.txt");
    FileInputStream fin = new FileInputStream("file4.txt");
    while(true)
    {
        System.out.println("Enter info in file:");
        fout.write(sc.nextLine().getBytes());
        //sometimes the line break is not recognized from the shell
        fout.write('\n');

        System.out.println("Would you like to enter more data?");
        if( sc.nextLine().charAt(0) == 'n' ) 
        {
            break;
        }
    }
    fout.close();
    sc.close();

    int chars=0,vowels=0,lines=0,words=2;
    int chars=0,vowels=0,lines=0,words=1;

    // With fin.read() you read 32 Bit integers from your input stream, 
    // which means that you have 4 chars "boxed" in one integer.
    int sizeOfStaticArray = 1024;
    //(ugly solution btw)
    byte[] arr = new byte[sizeOfStaticArray];
    fin.read(arr);
    byte i;
    for( int j = 0; j < sizeOfStaticArray; j++)
    {   
        i = (byte)arr[j];

        if(i == 0)
            break; 

        //You don't need casts to char 
        if( i != '\n' && i != ' ')
        {
            chars++;
        }
        //not else if. This is the main issue
        if( i == ' ' )
        {
            words++;
        }
        else if(i == 'a'||i  =='e'|| i == 'i'||  i =='o' || i == 'u')
        {
            vowels++;
        }
        else if( i == '\n' )
        {
            lines++;
            //increment word because the start of a line has no space
            words++;
        }
    }
    fin.close();
    System.out.println("Number of characters:"+chars);
    System.out.println("Number of vowels:"+vowels);
    System.out.println("Number of words:"+words);
    System.out.println("Number of lines:"+lines);

}
catch(Exception e)
{
    System.out.println(e);
}
}
}