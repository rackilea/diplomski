public interface Logic
{
    public void do();
}

public class MyClass
{
    private final Logic logic;

    public MyClass(final Logic logic)
    {
        this.logic = logic;
    }

    public void doLogic() { this.logic.do(); }
}

public class MyLogic implements Logic
{
   public void do() { /* custom logic goes here */ }
}

public class Main
{
    public static void main(final String[] args)
    {
        final MyClass myClass = new MyClass(new MyLogic());
        myClass.doLogic();
    }
}