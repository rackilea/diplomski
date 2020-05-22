// assume that the signleton is actually implemented correctly.
public class IHateSingletons
{
  Map<String, Contact> contactMap;

  public void storeThatStuffs(final ObjectOutputStream outputStream)
  {
    outputStream.writeObject(contactMap);
  }

  public void readThatStuffs(final ObjectInputStream inputStream)
  {
    contactMap = (Map<String, Contact>)inputStream.readObject();
}