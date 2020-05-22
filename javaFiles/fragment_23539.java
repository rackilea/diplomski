public class ObjectWithName
{
    private static final Set<String> names = new HashSet<String>();

    private String name;

    public ObjectWithName (String name) throws SomeException
    {
         if (!names.add(name))
             throw new SomeException();
         this.name = name;
    }

    public void setName (String name) throws SomeException
    {
         if (names.contains(name))
             throw SomeException();
         if (this.name != null)
             names.remove(this.name);
         names.add(name);
         this.name = name;         
    }
}