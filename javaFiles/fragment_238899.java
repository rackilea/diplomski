import java.util.Scanner;
import java.io.*;
public class Parser{
    public static void main(String[] args){ //excepiton catching needed
        Scanner sc = new Scanner(new File(args[0])); //for example
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] array = line.split(" ");
            switch(array.length){
                case 1: oneParamMethod(array[0]); break;
                case 2: twoParamMethod(array[0],array[1]); break;
                default: System.out.println("Strange line");
            }
        }
        sc.close();
    }
    public static void oneParamMethod(String param){
        int value = Integer.parseInt(param);
        // there will be your code
    }
    public static void twoParamMethod(String param1,String param2){
        int value1 = Integer.parseInt(param1);
        int value2 = Integer.parseInt(param2);
        // there will be your code
    }
}