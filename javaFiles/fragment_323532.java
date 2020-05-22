public interface Comparing<T>
{
    public int compare (T obj);
}

public class vInteger extends Integer implements Comparing<vInteger>
{
    public int compare (vInteger obj)
    {
        // now you can access obj.getIntValue() without any casting
    }
}