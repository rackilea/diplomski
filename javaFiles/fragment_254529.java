import com.thoughtworks.xstream.converters.basic.DoubleConverter;

public class MyDoubleConverter extends DoubleConverter
{
    @Override
    public String toString(Object obj)
    {
        return (obj == null ? null : YourFormatter.format(obj));
    }
}