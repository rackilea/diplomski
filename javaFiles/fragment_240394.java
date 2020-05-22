import java.io.*;


public class Temp {

  int count = 0;

  private void getFile(String dirPath) {
    File f = new File(dirPath);
    File[] files = f.listFiles();

    if (files != null) {
      for (File file : files) {
        if (file.getName().contains("DAPI")) {
          String dapiFile = file.getName();
          String gfpFile = dapiFile.replace("DAPI", "GFP");
          doSomething(dapiFile, gfpFile);
        }
      }
    }
  }

  //Do Something does nothing right now, expand on it.
  private void doSomething(String dapiFile, String gfpFile) {
    System.out.println(new File(dapiFile).getAbsolutePath());
    System.out.println(new File(gfpFile).getAbsolutePath());
  }

  public static void main(String[] args) {
    Temp app = new Temp();
    app.getFile("C:\\tmp\\");
  }

}