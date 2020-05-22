void runTest(String[] text, int[] number, String url, Sort sortFunction) {

  File directory = new File(url);
  File[] listOfFiles = directory.listFiles();
  for (File file : listOfFiles) {
    //println(file.getName());
    text = loadStrings(file);
    number = int(text);

    sortFunction.sort(number);
  }
}