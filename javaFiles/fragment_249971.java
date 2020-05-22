import java.io.*;

public class TwoNum {

public static void main(String[] args){

    String first="";
    String second="";

    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

    try{
        System.out.print("Input the first number: ");
        first = in.readLine();

        System.out.print("Input the second number: ");
        second = in.readLine();

    } catch(IOException e){
        System.out.println("Error!");
    }

    int number1=Integer.parseInt(first);
    int number2=Integer.parseInt(second);

    String result = null;

    if( number1 == number2 )
        result = "EQUIVALENT";
    else
        result = ( number1 > number2 ) ? "GREATER THAN" : "LESS THAN";

    System.out.println( result );

    }
}