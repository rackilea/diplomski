import java.util.Scanner;

class  TestForNull {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string1;
        string1 = input.next(); 

        LargeInteger firstInt = new LargeInteger(string1);

        System.out.printf ("First integer: %s \n", firstInt.display());
    }

}