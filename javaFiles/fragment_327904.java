public class Book
{
  private int id;
  private static int lastID = 0;

  public Book ()
  {
    id = ++lastID; // pre-increament
  }
}