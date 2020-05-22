FileOutputStream fos = new FileOutputStream("log.txt");
    PrintStream out = new PrintStream(fos);
    System.setOut(out);
    System.setErr(out);

    System.out.println("Logged to file");