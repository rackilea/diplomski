private static double getDouble(String name) {
    double res = 0;
    Scanner s = new Scanner(System.in);
    while (true) {
        try {
            System.out.print("Please input " + name + ":");
            res = Double.parseDouble(s.nextLine()); // Just get the user input as a string then try to convert it into a double
            break; // if there is no error in the string to double conversion it means that the input is valid, thus break the loop
        } catch (Exception e) { // catch possible errors in case the input is invalid
            System.out.println("Your input is invalid!"); // print desired error message then the loop will execute again getting another user input
        }
    }
    s.close();
    return res;
}