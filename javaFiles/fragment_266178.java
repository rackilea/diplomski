public class Testing
{
    public static void main()
    {
        X x1 = new X();
        X x2 = new Y(); //this is the declare of x2
        Y y2 = new Y();
        Y y3 = (Y) x2;
        System.out.println(x1.m_X(0));
        System.out.println(x2.m_X(0));
        System.out.println(((Y) x2).m_Y(0)); // fixed
        System.out.println(y3.m_Y(0));
    }
}