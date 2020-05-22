public class Parent
{
}

public class Child1 : Parent
{
}

public class Child2 : Parent
{
}

public class Action
{
    private static Dictionary<Type, Action<Parent>> _d = new Dictionary<Type, Action<Parent>>()
                                                    {
                                                        {typeof(Child1), p=>action((Child1)p)},
                                                        {typeof(Child2), p=>action((Child2)p)},
                                                        {typeof(Parent), p=>action(p)}
                                                    };
    public static void perform(Parent p)
    {
        _d[p.GetType()](p);
    }

    private static void action(Parent p)
    {

    }

    private static void action(Child1 c1)
    {

    }
    private static void action(Child2 c2)
    {

    }
}



class Program
{
    static void Main(string[] args)
    {
        Parent p = new Child1();
        Action.perform(p);
    }
}`enter code here`