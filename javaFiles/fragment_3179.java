FileOutputStream f = new FileOutputStream("file.txt");

  System.setOut(new PrintStream(f));

  // this text will get redirected to youe file
  System.out.println("This is System class!!!");