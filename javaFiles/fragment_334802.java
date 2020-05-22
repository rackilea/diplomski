interface Dao {
    List<Foo> getAllFoo();
}

public class MyDao implements Dao {

    public MyDao() {
    }

    public List<Foo> getAllFoo() {
        //.. get list of foo from database. No need to use transactions
    }

    public static void main(String[] args) {
        Dao dao = new MyDao();
        InvocationHandler handler = new TransactionProxyHandler(dao);
        Dao proxy = (Dao) Proxy.newProxyInstance(MyDao.class.getClassLoader(), MyDao.class.getInterfaces(), handler);
        List<Foo> all = proxy.getAllFoo();
    }
}


class TransactionProxyHandler implements InvocationHandler {

    protected Object delegate;
    PlatformTransactionManager txm = new PlatformTransactionManager();

    public TransactionProxyHandler(Object delegate) {
        this.delegate = delegate;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        TransactionStatus status = txm.getTransaction();
        Object res = null;
        try {
            res = method.invoke(delegate, args);
            txm.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            txm.rollback(status);
        }
        return res;
    }
}