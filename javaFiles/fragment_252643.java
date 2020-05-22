public abstract class AnAbstractClass
{
    public AnAbstractClass(String foo, String bar) {
        System.out.format("created with (%s, %s)\n", foo, bar);
    }
}

public class BaseClass extends AnAbstractClass
{
    public BaseClass(String foo, String bar) {
        super(foo, bar);
    }
}

public interface I
{
    public AnAbstractClass k();
}

public class Implementation implements I
{
    @Override public AnAbstractClass k() {
        return new BaseClass("hello", "world");
    }
}

public class Demo
{
    public static void main(String[] args) {
        I i = new Implementation();
        AnAbstractClass a = i.k();
    }
}