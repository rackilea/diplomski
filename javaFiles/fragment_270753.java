import java.util.Scanner;
class Test{
    public static void main (String [] args)
    {
        Scanner stringScanner = new Scanner (System.in);
        System.out.println ("What is your name?");

        String nameOfPerson = stringScanner.nextLine();
        System.out.println("Name : "+nameOfPerson+" & length : "+nameOfPerson.length());
        int lengthOfName = nameOfPerson.length();
        String result = "";
        for (int i = lengthOfName-1; i >= 0; i--) {
            result+=nameOfPerson.charAt(i);
        }
        System.out.println(result);
    }
}