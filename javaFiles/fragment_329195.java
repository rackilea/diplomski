public class InputStreamNameProvider implements NameProvider
{
  private InputStream inputStream;

  // Constructor 

  public String getNameForId(String id)
  {
     // return name loaded via inputStream
  }
}

public class RegistryNameProvider implements NameProvider
{
  public String getNameForId(String id)
  {
     return Registry.getName(id);
  }
}