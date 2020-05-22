public static void main(String[] args) {
  String dataFromFile = null, dataFromDataBase = null;
  try {
    try {
      dataFromFile = readFile();
    } catch (IOException e) {
       // ignore exception
       // String dataFromFile will be set to null
       // as there was an exception
    }
    // imagine many lines of code here
    dataFromDataBase = readDatabase(dataFromFile.getKey());
  } catch (IOException e) {
     // ignore exception
  }

  // imagine many lines of code here
  System.out.println(dataFromFile.replace(" ", ""));
  //imagine many lines of code here
  System.out.println(dataFromDataBase.getKey());
}
private static String readFile() throws IOException {
  // throws ioexception
}
private static String readDatabase(String key) throws IOException {
  // throws ioexception
}