public MyClass
{
  private static List<MyObject> myObjects = new ArrayList<>();

  static
  {
    loadMyObjects(new FileReader("myfile.csv"));
  }

  /* package */ static void loadMyObjects(Reader reader)
  {
    try
    {
      try (MyObjectReader reader = new new MyObjectReader(reader))
      {
        MyObject myObject;

        while ((myObject = reader.read()) != null) 
        {
          myObjects.add(myObject);
        }
      }
    }
    catch (IOException e)
    {
      ...
    }
  }
}