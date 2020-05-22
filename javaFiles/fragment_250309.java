public class FileReader
{
  public static void main(String[] args) throws FileNotFoundException
  {

    StringBuilder stringBuilder = new StringBuilder();
    Scanner scanner = null;
    int count = 0;
    try
    {
      scanner = new Scanner(new BufferedReader(new java.io.FileReader("d:\\text.txt")));
      while (scanner.hasNext())
      {
        String str = scanner.next();
        char[] myChar = str.toCharArray();
        for (char c : myChar)
        {
          stringBuilder.append(c);
          count++;
          if (count == 16)
          {
            count = 0;
            stringBuilder.append("\n");
          }
        }
      }
      System.out.println(stringBuilder.toString());
    }
    finally
    {
      if (scanner != null)
      {
        scanner.close();
      }
    }
  }
}