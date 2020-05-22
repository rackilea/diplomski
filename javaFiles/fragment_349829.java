import java.util.*;

    class Split{

        public static void main(String [] args){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a String");
            String str= input.nextLine();
            String word = printLetters(str);
            System.out.println(word);
        }

        public static String printLetters (String a){
            return String.join(", ", a.split(""));
        }
    }