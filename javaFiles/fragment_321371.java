public class MyCall
{

    public void a(){System.out.println("a");}
    public void b(){System.out.println("b");}

    public static void main(String... args)
    {
        new MyCall().go();
    }

    public void go()
    {
        Class<? extends MyCall> class1 = this.getClass();
        Method aMethod = class1.getMethod("b", null);
        Method bMethod = class1.getMethod("a", null);
        Object fake = false ? aMethod.invoke(this, null) : bMethod.invoke(this, null);
        Object fake2 = true ? aMethod.invoke(this, null) : bMethod.invoke(this, null);
    }
}