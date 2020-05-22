public class Main
{
    private static final ThreadLocal<MBassador> THREAD_LOCAL = new ThreadLocal<>();
    public static void main(String[] args)
    {
        THREAD_LOCAL.set(myObject)
        try {
            Application.launch(new View().getClass(), args);
        } finally {
            THREAD_LOCAL.remove();
        }
    }

    public static MBassador getMBassador() {
        return THREAD_LOCAL.get();
    }
}