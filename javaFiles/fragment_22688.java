public class PostCodeCheck {
public static void main(String[] args) {
    String postcode = "ca14 3xn";
    System.out.print("\"" 
            + postcode 
            + "\" is " 
            + postcode.matches("[A-Z]{2}[0-9]{1,2} [0-9]{1,2}[A-Z]{2}"));
    postcode = "CA14 3XN";
    System.out.println(" And \n\"" 
            + postcode + "\" is " + postcode.matches("[A-Z]{2}[0-9]{1,2} [0-9]{1,2}[A-Z]{2}")
            + " \nbecause it accepts postcode with capital letter only!");
}