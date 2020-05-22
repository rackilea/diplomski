FileWriter fileWriter = null;
String content = "A string to be written to file";
File newTextFile = new File("C:\\output.txt");
fileWriter = new FileWriter(newTextFile);
fileWriter.write(content);
fileWriter.close();