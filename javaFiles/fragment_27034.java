public class MuleBootstrap
{
    public static void main(final String[] args) throws Exception
    {
        final MuleServer ms = new MuleServer("mule-config.xml");
        ms.start(true, true);
    }
}