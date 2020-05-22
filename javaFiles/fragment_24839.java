public interface MyType { /* your actual implementation */ }

public interface MyTypeChecker
{
    boolean isType(String value);
    MyType getType(String value);
}

public class MyTypeFactory
{
    public /* static */ MyType getType(String value)
    {
        MyType loaded = null;

        for (MyTypeChecker checker : ServiceLoader.load(MyTypeChecker.class))
        {
            if (checker.isType(value))
            {
                loaded = checker.getType(value);
                break;
            }
        }

        return loaded;
    }
}