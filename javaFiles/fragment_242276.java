import java.lang.reflect.Constructor;

public class GetConstructorsReturnType
{
    public static void main(String[] args) throws Exception
    {
        // This causes a warning, due to the cast, but imagine
        // this was possible
        Constructor<DerivedA> constructorsA[] =
            (Constructor<DerivedA>[])DerivedA.class.getConstructors();

        // The following lines are valid due to the subtype
        // relationship, but would not be valid if constructorsA
        // was declared as "Constructor<?>"
        Constructor<? extends Base> constructors[] = constructorsA;
        constructors[0] = DerivedB.class.getConstructor();

        // This causes a ClassCastException (and would also not
        // be possible constructorsA was declared as "Constructor<?>"
        DerivedA instance = constructorsA[0].newInstance();
    }
}
class Base
{
}
class DerivedA extends Base
{
    public DerivedA()
    {
    }
}
class DerivedB extends Base
{
    public DerivedB()
    {
    }
}