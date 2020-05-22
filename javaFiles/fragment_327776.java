// Base interface
public interface DataProcessor
{
    DataProcessor method1(String classname);
    DataProcessor method2(String classname);
}

// Concrete interface
public interface PlainTextProcessor extends DataProcessor
{
    PlainTextProcessor method1(String classname);
    PlainTextProcessor method2(String classname);
    PlainTextProcessor method3(String[] data);
}

// Concrete implementation
public class TabbedFile implements PlainTextProcessor
{
    @Override
    public TabbedFile method1(String classname)
    {
        ...
        return this;
    }

    @Override
    public TabbedFile method2(String classname)
    {
        ...
        return this;
    }

    @Override
    public TabbedFile method3(String[] data)
    {
        ...
        return this;
    }
}