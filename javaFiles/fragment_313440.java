public MyClass
{
  private static List<MyObject> myObjects = new ArrayList<>();

  static
  {
    try
    {
      try (BufferedReader reader = new BufferedReader(new FileReader(myfile.csv))
      {
        String line;

        while ((line = reader.readLine()) != null) 
        {
          String[] tokens = line.split(",");
          myObjects.add(new MyObject(tokens[0], tokens[1], tokens[2]));
        }
      }
    }
    catch (IndexOutOfBoundsException e)
    {
      ...
    }
    catch (IOException e)
    {
      ...
    }
  }
}