public static void main(String[] args) {
    StringBuilder string = new StringBuilder();
    Scanner input = new Scanner(System.in);
    boolean flag = true;
    while (flag) {

        // Capture all characters entered, including numbers with multiple digits
        String in = input.nextLine();

        // If no characters were entered, then the [ENTER] key was pressed
        if (in.isEmpty()) {
            // User is done adding characters; exit the loop
            flag = false;
        } else {

            // Otherwise, get the text entered and add it to our final string
            string.append(in);
        }
    }

    System.out.println("Final String: " + string);
}