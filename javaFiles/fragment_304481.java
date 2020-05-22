System.out.println("Enter details, separating each with a ':' ");
    Scanner scan = new Scanner(System.in);
    while (scan.hasNextLine()) {
        String line = scan.nextLine();
        if (line.equals("quit")) {
            break;
        }
        final String[] split = line.split(":");
        // handle it
    }