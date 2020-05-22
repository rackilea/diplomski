Scanner stdIn = new Scanner(System.in);

    System.out.print("Enter your first and last name separated by a space: ");
    String first = stdIn.next(); // first name
    String last = stdIn.next(); // last name

    stdIn.close();

    try (FileWriter writer = new FileWriter(new File("Output.txt"), true); // autocloseable
            PrintWriter output = new PrintWriter(writer)) { // autocloseable

        output.print("Your initials are " + first.charAt(0) + last.charAt(0) + ".");

    } catch (IOException e) {
        e.printStackTrace();
    }