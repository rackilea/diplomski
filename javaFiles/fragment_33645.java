public class ParadoxTestWithJni
{
    static
    {
        System.loadLibrary("Paradox");
    }
    public static void main(String[] args)
    {
        Paradox paradox = createParadox();
        System.out.println("This is paradox: "+paradox);
    }

    private native static Paradox createParadox();
}