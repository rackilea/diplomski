public abstract class GenericClass extends JFrame
{
    protected static String FIELD_1;
    protected static String FIELD_2;
    protected static String FIELD_3;

    public GenericClass()
    {   // null +" " +null+null = `null nullnull`
        super(FIELD_1+" "+FIELD_2+FIELD_3);
    }
}