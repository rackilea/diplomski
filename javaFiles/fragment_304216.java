final static String DOUBLE_PATTERN = "[0-9]+(\.){0,1}[0-9]*";
final static String INTEGER_PATTERN = "\d+";

Scanner scan = new Scanner(System.in);
String input = scan.next();

if (Pattern.matches(INTEGER_PATTERN, input)) {
    System.out.println("Input is Integer");
    //enter a double again
} else if (Pattern.matches(DOUBLE_PATTERN, input)) {
    System.out.println("Input is Double");
    //break
} else {
    System.out.println("Input is not a number");
    if (input.length == 1) {
        System.out.println("Input is a Character");
        //enter a double again
    } else {
        System.out.println("Input is a String");
        //enter a double again
    }
}