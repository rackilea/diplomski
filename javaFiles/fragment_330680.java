import java.io.File;

public class FilePmrDetector {
  public static void main(String[] args) {
    listFiles(new File("/"));
  }

  public static void listFiles(File file) {
    if (file == null) {
      return;
    }

    doSomeActionOnFile(file);

    if (file.isDirectory()) {
      File[] fs = file.listFiles();

      if (fs != null) {
        for (File f : fs) {
          listFiles(f);
        }
      }
    }
  }

  public static void doSomeActionOnFile(File file) {
    String fileName = file.getAbsolutePath();
    String printOut = "";

    if (isAPmr(file)) {
      printOut = printOut + fileName;
    }
    if (printOut != "") {
      System.out.println(printOut);
    }
  }

  public static boolean isAPmr(File file) {
    if (file != null) {
      String name = file.getAbsolutePath();
      return name.matches("^.*(\\d{5},[a-zA-z0-9]{3},\\d{3}).*$");          
      // I tested with: return name.contains(".exe");
    }

    return false;
  }
}