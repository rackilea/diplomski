PrintWriter writer = new PrintWriter("yourfilename.txt", "UTF-8");
writer.println("write something to your file");
writer.close();

// now you can open the file
File yourFile = new File("yourfilename.txt");

// to display it's location on the hard drive
System.out.println(yourFile.getAbsolutePath());