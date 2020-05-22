Scanner keyboard = new Scanner(System.in);
while (true) {
    System.out.println("Please enter a letter :: quit to stop");
    String str = (keyboard.hasNextLine()) ? keyboard.nextLine()
            : "quit";
    if (str.equalsIgnoreCase("quit")) {
        break;
    }
    char ch = str.charAt(0);
    if (Character.isUpperCase(ch)) {
        System.out.printf("%c is uppercase%n", ch);
    } else if (Character.isLowerCase(ch)) {
        System.out.printf("%c is lowercasee%n", ch);
    } else if (Character.isDigit(ch)) {
        System.out.printf("%c is a digit%n", ch);
    } else {
        System.out.printf("%c is not uppercase, lowercase "
                + "or a digit%n", ch);
    }
}