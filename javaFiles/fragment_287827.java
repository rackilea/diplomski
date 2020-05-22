File file = new File("path/to/file.txt");
Scanner sc = new Scanner(file);
String thisLine = null;
while (sc.hasNextLine()){
   thisLine = sc.nextLine();
}