import org.mvel2.MVEL;

public class Main
{
    public static void main(final String[] args)
    {
        final String foo = "4 * 24 + Math.sqrt(36) - 5";
        System.out.println(MVEL.eval(foo));
    }
}