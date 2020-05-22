public static boolean isUIThread()
{
    Object uiThread = null;

    try
    {
        Class displayClass = Class.forName("org.eclipse.swt.widgets.Display");
        Method getDefaultMethod = displayClass.getDeclaredMethod("getDefault", new Class[] { });
        Object display = getDefaultMethod.invoke(null, new Object[] { });

        Method getThreadMethod = displayClass.getDeclaredMethod("getThread", new Class[] { });
        uiThread = getThreadMethod.invoke(display, new Object[] { });
    }
    catch(Exception e)
    {
        log.warn("Could not determine UI thread using reflection", e);
    }

    return (Thread.currentThread() == uiThread);
}