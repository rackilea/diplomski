public class TestClass {

public static void main(String[] args) {
    new TestClass().printChars("JOE BLOGGS", "is an employee");
}

public void printChars(String baseString, String additionalString) {
    System.out.println(baseString.charAt(1));
    System.out.println(baseString.charAt(5));
    System.out.println(baseString + " " + additionalString.toUpperCase());
}}