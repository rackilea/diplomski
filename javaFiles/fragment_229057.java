public class LifeCycle
{
  @PostContextCreate
  public void postContextCreate()
  {
    // TODO start up code here
  }

  @PreSave
  public void preSave()
  {
     // TODO add shutdown code here
  }
}