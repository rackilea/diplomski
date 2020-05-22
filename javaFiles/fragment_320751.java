StringWriter stringWriter = new StringWriter();
PrintWriter writer = new PrintWriter(stringWriter, true);
writer.println("line1");
writer.println("line2");
writer.println("line3");
useString(stringWriter.toString());