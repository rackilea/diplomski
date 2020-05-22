static {
    try{
        sessionFactory = new Configuration().configure("/hibernateConn/hibernate.cfg.xml").buildSessionFactory();
    }catch(Throwable ex){
        System.err.println("++++Initial SessionFactory creation failed.++++: " + ex);
        ex.printStackTrace();
    }
}

public static SessionFactory getSessionFactory(){
    return sessionFactory;
}