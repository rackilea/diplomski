class Sandbox
{
    public static void main(String args[]) throws Exception
    {
        System.out.println(getfalse(10, 60));
    }

    public static String getfalse(Integer start, Integer stop) throws Exception
    {
        return
            start + "\n" +
            Sandbox.class.getMethod("get" + (start == stop), Integer.class, Integer.class)
            .invoke(Sandbox.class, start+1, stop);
    }

    public static String gettrue(Integer start, Integer stop)
    {
        return "";
    }
}