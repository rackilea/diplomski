class MyContext extends InitialContext {

    private Hashtable store;

    public MyContext(Hashtable store) throws NamingException {
        super(true);
        this.store = store;
    }

    @Override
    public void bind(String name, Object obj) {
        store.put(name, obj);
    }

    @Override
    public Object lookup(String name) {
        return store.get(name);
    }    

}



public class FooMain {

    private static final int    ANSWER    = 42;
    private static final String JNDI_NAME = "/config/theAnswerToEverything";

    public static void main (String args[]) throws NamingException {
        Context context = new InitialContext();
        putInContext(                    JNDI_NAME, ANSWER);

        int answer = retrieveFromContext(JNDI_NAME);
        Assert.assertEquals(ANSWER, answer);
        System.out.printf("%d\n", answer);
    }


    private static void putInContext(final String key, final Object value) throws NamingException {
        Context context = new InitialContext();
        context.bind(key, value);
    }

    private static int retrieveFromContext(final String key) throws NamingException {
        Context context = new InitialContext();
        return (int) context.lookup(key);
    }
}


public class MyContextFactory implements InitialContextFactory {

    private static Hashtable store = new Hashtable();

    /*
      Do not confuse [store] with [environment]. They serve different
      purposes.
     */

    @Override
    public Context getInitialContext(Hashtable environment) throws NamingException {
        return new MyContext(store);
    }
}