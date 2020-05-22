public class ATest
{
    public static void main(String[] args) throws UnsupportedEncodingException
    {
        int i = 5;
        Object equals = new Object();

        boolean b = full.access(i, "equals", equals);

        System.out.println(b);
    }

    public static class full
    {
        public static <T, S, P> S access(final T object, final String function, final P parameter)
        {
            return AccessController.doPrivileged(new PrivilegedAction<S>()
            {
                @Override
                public S run()
                {
                    try
                    {
                        if (parameter == null)
                        {
                            Class[] argTypes = {};
                            Object passedArgv[] = {};
                            return (S) object.getClass().getMethod(function, argTypes)
                                    .invoke(object, passedArgv);
                        }
                        else
                        {
                            Class[] argTypes = { parameter.getClass() };
                            Object passedArgv[] = { parameter };
                            return (S) object.getClass().getMethod(function, argTypes)
                                    .invoke(object, passedArgv);
                        }
                    }
                    catch (NoSuchMethodException ex)
                    {
                        Logger.getLogger(full.class.getName()).log(Level.ALL, null, ex);
                    }
                    catch (SecurityException ex)
                    {
                        Logger.getLogger(full.class.getName()).log(Level.ALL, null, ex);
                    }
                    catch (IllegalAccessException ex)
                    {
                        Logger.getLogger(full.class.getName()).log(Level.ALL, null, ex);
                    }
                    catch (InvocationTargetException ex)
                    {
                        Logger.getLogger(full.class.getName()).log(Level.ALL, null, ex);
                    }
                    return null;
                }
            });
        }
    }
}