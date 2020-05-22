class Super 
{
    static int i = 90;
    public static void setI(int in)
    {
        i = in;
    }
    public static int getI()
    {
        return i;
    }
}
class Child1 extends Super{}
class Child2 extends Super{}
public class ChildTest
{
    public static void main(String st[])
    {
        System.out.println(Child1.getI());
        System.out.println(Child2.getI());
        Super.setI(189);//value of i is changed in super class
        System.out.println(Child1.getI());//same change is reflected for Child1 i.e 189
        System.out.println(Child2.getI());//same change is reflected for Child2 i.e 189
    }
}