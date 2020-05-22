public static void main(String[] args) {
  File outFile = new File(System.getenv("HOME") // <-- or "C:/" for Windows.
      + "/hello.txt");
  try {
    PrintWriter pw = new PrintWriter(outFile);
    pw.println("Go Falcons");
    pw.close();
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  }
}