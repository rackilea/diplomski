Scanner input = new Scanner(System.in);
String ls = System.lineSeparator();

// Prompt 1:
// We want the User to enter an inclusive number from 1 to 5.
int x = 0;
String userIN = "";
while (x < 1 || x > 5) {
    System.out.print("Enter an Integer Number from 1 to 5 (q to quit): --> ");
    userIN = input.nextLine();
    if (userIN.toLowerCase().charAt(0) == 'q') {
        System.out.println("Quitting!");
        System.exit(0);
    }
    // Is it a signed or unsigned integer number with 1 or more digits?
    if (userIN.matches("-?\\d+")) {
        System.out.println("Success! The nextLine() method accepted your input" + ls
                + "to be a string representation of an Integer value!");
        x = Integer.parseInt(userIN);
    }
    else {
        System.err.println("Invalid Input! An Integer number from 1 to 5 only!" + ls);
        continue;
    }
    if (x < 1 || x > 5) {
        System.err.println("But...this application does not accept it!");
        System.err.println("We asked for a number from 1 to 5! Try again..." + ls);
    }

}
System.out.println(x + " Was Supplied! - DONE!" + ls);

// Prompt 2:
// We want the User to enter any float or double type numerical value.
double d = Double.MIN_VALUE;
while (d == Double.MIN_VALUE) {
    System.out.print("Enter a float or double type number (q to quit): --> ");
    userIN = input.nextLine().toLowerCase().trim();
    if (userIN.charAt(0) == 'q') {
        System.out.println("Quitting!");
        System.exit(0);
    } 
    // Get rid of the type designator from value if it exists.
    if (userIN.endsWith("f") || userIN.endsWith("d")) {
        userIN = userIN.substring(0, userIN.length() - 1);
    }
    // Is it a signed or unsigned integer, float, or double type number?
    if (userIN.matches("-?\\d+(\\.\\d+)?")) {
        System.out.println("Success! The nextLine() method accepted your input" + ls
                         + "to be a string representation of an Integer, float," + ls
                         + "or double type value!");
        d = Double.parseDouble(userIN);
    }
    else {
        System.err.println("Invalid Input! A Float or Double type numerical value is required!" + ls);
        d = Double.MIN_VALUE;
    }
}
System.out.println(d + " Was Supplied! - DONE!");