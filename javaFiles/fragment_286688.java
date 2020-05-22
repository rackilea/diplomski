public class SuperClass
{
    public void method1(SuperClass this)
    {
        System.out.println("superclass method1");
        this.method2(this); // <--- this == mSubClass
    }

    public void method2(SuperClass this)
    {
        System.out.println("superclass method2");
    }

}

public class SubClass extends SuperClass
{
    @Override
    public void method1(SubClass this)
    {
        System.out.println("subclass method1");
        super.method1(this);
    }

    @Override
    public void method2(SubClass this)
    {
        System.out.println("subclass method2");
    }
}



public class Demo 
{
    public static void main(String[] args) 
    {
        SubClass mSubClass = new SubClass();
        mSubClass.method1(mSubClass);
    }
}