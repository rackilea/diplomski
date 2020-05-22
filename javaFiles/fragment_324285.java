String file = "userStrings.txt";
    Scanner scan = new Scanner(System.in);
    scan.useDelimiter("\\n");
    System.out.println("Enter DONE to terminate");
    try (PrintWriter fw = new PrintWriter(new File(file))) {
        String line = null;
        while ((line = scan.nextLine()) != null) {
            if (line.trim().equalsIgnoreCase("done")) {
                System.out.println("Exiing");
                System.exit(0);
            }
        }
        fw.println(line);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(MaxByTest.class.getName()).log(Level.SEVERE, null, ex);
    }