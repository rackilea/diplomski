ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream oldOut = System.out;
    System.setOut(new PrintStream(out));

    // System.in read code

    System.setOut(oldOut);
    System.out.println(out.toString());