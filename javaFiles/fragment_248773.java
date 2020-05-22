Scanner input = new Scanner(System.in);
System.out.println("Please enter a password:");
String password = input.nextLine();
boolean valid = password.length() >= 8;

if (!valid) {
    System.out.println("Password must have at least 8 characters.");
} else {
    for (char ch : password.toCharArray()) {
        if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
            System.out.println("Password can only contain letters and numbers.");
            valid = false;
            break;
        }
    }
}
if (valid) {
    System.out.println("Password accepted!");           
}