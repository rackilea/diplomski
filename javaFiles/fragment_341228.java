public class Icons
{
  public static final byte[] compileIcon;
  static
  {
    compileIcon = readFileToBytes("compileIcon.gif");
  }
  //... (I assume there are several other icons)
  private static byte[] readFileToBytes(String filename)
  {
    try {
      File file = new File(filename);
      byte[] bytes = new byte[(int)file.length()];
      FileInputStream fin = new FileInputStream(file);
      fin.read(bytes);
      fin.close();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}