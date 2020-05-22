PrintStream original = System.out;
ByteArrayOutputStream buffer = new ByteArrayOutputStream(4096);
PrintStream tempPrinter = new PrintStream(buffer);
System.setOut(tempPrinter);

// call methods that print

tempPrinter.flush();
System.setOut(original);

String output = buffer.toString(); // contains all output, including new lines