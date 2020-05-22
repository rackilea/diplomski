// Shared library
public interface IBaseClassFactory
{
    BaseClass CreateNew(String p1, int p2, Boolean p3);
}

public abstract class BaseClass
{
}

// Application code
public class SubClassOne : BaseClass
{
}

public class SubClassTwo : BaseClass
{
}

// Note that this consumer depends on IBaseClassFactory.
public class SomeConsumer
{
    private IBaseClassFactory baseClassFactory;

    public SomeConsumer(IBaseClassFactory factory)
    {
        this.baseClassFactory = factory;
    }

    public void Consume()
    {
        BaseClass instance = this.baseClassFactory
            .CreateNew("foo", 0, false);

        // use instance
    }
}  

// Composition root
class BaseClassFactory : IBaseClassFactory
{
    public BaseClass CreateNew(String p1, int p2, Boolean p3)
    {
        BaseClass baseObj = null;

        if ((baseObj = SubClassOne.ofType(p1, p2, p3)) != null)
           return baseObj;
        // etc
        else
            return new SubClassDefault(p1, p2, p3);
    }
}