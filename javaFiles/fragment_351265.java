File file = new File("test1.txt");
file.createNewFile();

PrintWriter writer = new PrintWriter("test1.txt");
writer.println("N: ");
writer.println("E: ");
writer.println("D: ");
writer.flush();
writer.close();