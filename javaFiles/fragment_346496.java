public class Main {

    private static final String JNDI = 
                    "java:global/yourApp/YourEJBBean!com.test.YourEJBBeanRemote";

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();

        YourEJBBeanRemote sr = (YourEJBBeanRemote)ctx.lookup(JNDI);

        // Invoke some method on 'sr'
    }
}