public class SudokuSolver
{
  public static void main(String[] args)
  {
    try
    {
      // other statements
      throw new Exception();
    }
    catch (Exception e)
    {
      System.out.println("Illegal puzzle.");
      System.exit(1);
    }
  }
}