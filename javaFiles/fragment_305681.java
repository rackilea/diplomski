public class VMGeneric<A>
{
    private A objVariable;

    public VMGeneric(A localVariable)
    {
        objVariable = localVariable;
    }

    public String getNameOfGenericType()
    {
        return objVariable.getClass().getCanonicalName();
    }

    public static void main(String[] args)
    {
        VMGeneric<String> o1 = new VMGeneric<>("");
        VMGeneric<Object> o2 = new VMGeneric<>(new Object());

        System.out.println(o1.getNameOfGenericType());
        System.out.println(o2.getNameOfGenericType());
    }
}