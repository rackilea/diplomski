import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class BorjaTask7 {
    private static Scanner input;


    public static void main(String[] args) {

        input = new Scanner(System.in);

        int option = 0;
        while (option !=4)  {
        System.out.print(
                "Main menu\n" +

                        "1: infix to Postfix\n" + // 16
                        "2: Postfix Expressions\n" + //14
                        "3: Descending Order\n" +
                        "4: Exit\n" + "\n" +
                        "Enter a choice: ");

        option = input.nextInt();



        switch (option) {
        case 1: 

            String exp1 = args[0];
            String result1 = Task16.infixToPostfix(exp1);
            System.out.println("Infix Expression     Postfix Expression");
            System.out.println(exp1 + "              " + result1);

        break;

        case 2: 

            String exp =args[0];
            String result = Task14.infixToPostfixConversion(exp);
            System.out.println("Conversion of infix <-> to Postfix is");
        System.out.println(exp + "                        " + result);

        case 3: 
            String filename = args[0];
            TreeSet<String> treeSet = new TreeSet<String>(Collections.reverseOrder());
            try{
                input = new Scanner(new File(filename));
                String line;
                while ((line = input.nextLine())!=null){
                    String[] tokens = line.split("[|\n|\t|\r|.|,|)|(|-|\"]");

                    for (int i = 0; i  < tokens.length; i++)
                        treeSet.add(tokens[i]);
                    }
                }
            catch (Exception ex){

            }
            System.out.println("\nDisplay words in descending order");
            Iterator<String> iterator = treeSet.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                }
            break;

        case 4:
            //option = 0;   
        default:
        System.out.print("You have exited. ");
            break;
            }
        } 
        }
    }