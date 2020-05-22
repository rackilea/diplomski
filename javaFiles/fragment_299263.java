public class MySecurityManager extends SecurityManager
{

    public MySecurityManager()
    {
        super();
    }

    @Override
    public void checkPropertyAccess(String key)
    {
        if ("javax.xml.parsers.DocumentBuilderFactory".equals(key))
        {
            System.err.println("checkPropertyAccess(String :" + key + "): ");
            Thread.currentThread().dumpStack(); // or anything useful for
                                                // logging the context.
            new Throwable().printStackTrace(); // whatever, or use it with
            // PrintStream/PrintWriter, or some logging framework if configured.
        }
        super.checkPropertyAccess(key);
    }

    @Override
    public void checkPermission(Permission perm)
    {
        if (perm instanceof PropertyPermission)
        {
            PropertyPermission propPerm = (PropertyPermission) perm;
            System.err.println("checkPropertyAccess(String:" + propPerm.getName() + "):");
            Thread.currentThread().dumpStack(); // or anything useful for
                                                // logging the context.
            new Throwable().printStackTrace(); // whatever, or use it with
            // PrintStream/PrintWriter, or some logging framework if configured.
        }
        super.checkPermission(perm);
    }
}