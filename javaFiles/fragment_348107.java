public class TestClass
{
  private static boolean readAllFiles = false,readAllDirs = true;

  public static void main(String[] args)
  {
    //these two would result in COMPILE error if both vars were not static
    System.out.println("readAllFiles: " + readAllFiles);
    System.out.println("readAllDirs: " + readAllDirs);
  }
}