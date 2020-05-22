//While reading the file
BufferedReader reader = new BufferedReader(new InputStreamReader(new 
FileInputStream("C:\\temp\\myInputFile.txt"), "UTF-8"));

//While writing the file
PrintStream ps = new PrintStream(fos, true, "UTF-8");
ps.print(sender.toString());
ps.close();