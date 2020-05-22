private String urlText;
private String excelLocation;

private static void readFile(String fileName) {
   try {
     int lineNumber = 0;
     File file = new File(fileName);
     Scanner scanner = new Scanner(file);
     while (scanner.hasNextLine()) {
       lineNumber++;
       if (lineNumber == 1){
       urlText = scanner.nextLine();
       }
       else{
       excelLocation = scanner.nextLine();
     }
     scanner.close();
   } catch (FileNotFoundException e) {
     e.printStackTrace();
   }
 }