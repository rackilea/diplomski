public static Basicinfo getBean(Integer iduser) {
    Basicinfo u = null;
    Transaction tx = null;
    Session sess = NewHibernateUtil.getSessionFactory().openSession();
    try {

        Query q = sess.createQuery("from Basicinfo where iduser=" + iduser);
        u = (Basicinfo) q.uniqueResult();
        if (u == null) {
            tx = sess.beginTransaction();   //line 69
            u = new Basicinfo();
            u.setIduser(iduser);
            tx.commit();
        }           
    } catch (Exception ex) {
        ex.printStackTrace();
        if(tx != null) {
            try {
             tx.rollback();
            } catch(Exception e){e.printStackTrace;}
        }
    } finally {
        if(sess!=null) {
         sess.close();
        }
    }
    return u;
}