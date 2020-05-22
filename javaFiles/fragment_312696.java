class ClassOne {
    public int myInt;
}

class ClassTwo {
    public int myInt;
    public ClassTwo(ClassOne c)
    {
        myInt = c.myInt;
        c.myInt = 3;
    }
}

public class main
{
    public static void main(String[] args)
    {
        ClassOne c = new ClassOne();
        c.myInt = 1;
        System.out.println("C1: " + c.myInt);

        ClassTwo c2 = new ClassTwo(c);
        System.out.println("C2: " + c2.myInt);
        System.out.println("C1: " + c.myInt);

    }
}