try
    {
        Class<?> cls = Class.forName("javax.swing.JWindow");
        Method meth = cls.getMethod("setOpacity", float.class);
        meth.invoke(transparentWindow, 0.50f);
    }
    catch (Throwable e)
    {
        e.printStackTrace();
        try
        {
            Class<?> cls = Class.forName("com.sun.awt.AWTUtilities");
            Method meth = cls.getMethod("setWindowOpacity", Window.class,
                                        float.class);
            meth.invoke(null, transparentWindow, 0.50f);
        }
        catch (Throwable e1)
        {
            e1.printStackTrace();
        }
    }