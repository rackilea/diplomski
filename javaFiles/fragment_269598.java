public class Parent
{
    public Parent()
    {
        System.out.println("In parent constructor"); // 4 <------
    }
}


public class Child extends Parent
{
    private int age;

    public Child()
    {
        this(10); // 2 <------
        System.out.println("In child constructor with no argument"); // 6 <------
    }

    public Child(int age)
    {
        // 3 -- implicit call to super()  <------
        this.age = age;
        System.out.println("In child constructor with argument"); // 5 <------
    }

    public static void main(String[] args)
    {
        System.out.println("In main method"); // 1 <------
        Child child = new Child();
    }
}