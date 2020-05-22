PrintStream originalOut = System.out;
ByteArrayOutputStream baos = new ByteArrayOutputStream();
PrintStream myOutputStream = new PrintStream(baos);
System.setOut(myOutputStream);

// your JTidy code here

String capturedOutput = new String(baos.toByteArray(), StandardCharsets.UTF_8);
System.setOut(originalOut);

// Send capturedOutput to a JTextArea
myTextArea.append(capturedOutput);