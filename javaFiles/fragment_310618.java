public class Stringg {

    public static char getSecondChar(String myString) { 
        return myString.charAt(1); 
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a string: "); 
        String mystring = sc.nextLine();
        System.out.println("The second character is " + getSecondChar(mystring));

    }

}