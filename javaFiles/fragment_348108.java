public final class TestClass2
{
  public static void main(String[] args)
  {
    //these two DO result in COMPILE error, because both vars are private
    System.out.println("TestClass.readAllFiles: " + TestClass.readAllFiles);
    System.out.println("TestClass.readAllDirs: " + TestClass.readAllDirs);
  }
}