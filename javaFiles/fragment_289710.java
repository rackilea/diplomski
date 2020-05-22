import java.util.HashMap;
import java.util.ArrayList;

public class Example
{
    public static void main(String[] args)
    {
        new Example().run();
    }

    private ArrayList<Foo> FooList = new ArrayList<Foo>();

    public void run()
    {
        FooList.add(new Foo("abc", 1));
        FooList.add(new Foo("abc", 2));
        FooList.add(new Foo("def", 3));
        FooList.add(new Foo("abc", 4));
        FooList.add(new Foo("abc", 5));
        FooList.add(new Foo("ghi", 6));
        FooList.add(new Foo("def", 7));

        HashMap<String, Foo> map = new HashMap<String, Foo>();
        for (Foo bar: this.FooList)
        {
            if (!map.containsKey(bar.getName()))
            {
                map.put(bar.getName(), bar);
            }
            else
            {
                Foo foo = map.get(bar.getName());
                if (foo != null)
                    foo.doSomeThing();
                map.put(bar.getName(), null);
            }
        }
    }

    class Foo
    {
        public Foo(String name, int i)
        {
            this.name = name;
            this.i = i;
        }

        public String getName()
        {
            return name;
        }

        public void doSomeThing()
        {
            System.out.println(getName() + " " + i);
        }

        private String name;
        private int i;
    }
}