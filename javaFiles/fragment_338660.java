File file = new File("script.py");
FileOutputStream fis = new FileOutputStream(file);
PrintStream out = new PrintStream(fis);
System.setOut(out);
System.out.println("#!/usr/bin/python");
System.out.println("print 'hello world'");