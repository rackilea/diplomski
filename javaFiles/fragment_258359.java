public class FileReader
{
  public static void main(String args[])
  {
    ArrayList<List<String>> linesArrays = new ArrayList<List<String>>();

    FileInputStream fileInputStream = null;
    BufferedReader bufferedReader = null;
    try
    {
      fileInputStream = new FileInputStream("d:\\test.csv");
      bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

      String line = bufferedReader.readLine();
      while (line != null)
      {
        line = bufferedReader.readLine();
        if (line != null)
        {
          List<String> items = Arrays.asList(line.split(","));
          linesArrays.add(items);
        }
      }
      for (List<String> stringList : linesArrays)
      {
        System.out.println("items :" + stringList.size());
      }
    }
    catch (FileNotFoundException fileNotFoundException)
    {
      //todo Deal with exception
      fileNotFoundException.printStackTrace();
    }
    catch (IOException iOException)
    {
      //todo Deal with exception
      iOException.printStackTrace();

    }
    finally
    {
      try
      {
        if (bufferedReader != null)
        {
          bufferedReader.close();
        }
        if (fileInputStream != null)
        {
          fileInputStream.close();
        }
      }
      catch (IOException ex)
      {
        // not much you can do about this one
      }
    }
  }

}