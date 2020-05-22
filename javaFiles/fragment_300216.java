public class DAO {

    protected static final transient Logger log = Logger.getLogger(DAO.class);

    public static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public Session s = null;
    public Transaction t = null;

    public DAO(Session s) {
        this.s=s;
    }

    public void beginTransaction(Transaction t) {
        this.t=t;
    }

    private int exceptionErr=0;
    public void beginTransaction() {
        try {
            t=s.beginTransaction();
        } catch (Throwable t) {
            log.error(t,t);
        }
    }
    public void rollBackTransaction() {
        if (t!=null && t.isActive())
            t.rollback();
    }
    public void commitTransaction() {
        if (t!=null && t.isActive())
            t.commit();
    }

    public void finallyClose() {
        if (t!=null && t.isActive()) 
            t.rollback();
        if (s!=null && s.isOpen())
            s.close();
    }

    public Session getS() {
        return s;
    }

    public void setS(Session s) {
        this.s = s;
    }

    public Transaction getT() {
        return t;
    }

    public void setT(Transaction t) {
        this.t = t;
    }

}