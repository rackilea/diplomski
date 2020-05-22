private Transaction initQuery() throws HibernateException {
    mSession = HibernateUtil.getSessionFactory().openSession();
    mTransaction = mSession.beginTransaction();
    return mTransaction;    
}


public Conductor selectConductorByID(Integer id) {
    Conductor conductor = new Conductor();
    Transaction tx = null;
    try{
        tx = initQuery();
        conductor = (Conductor) mSession.get(Conductor.class, id);
       //flush and commit before close
        mSession.flush();
        tx.commit();
    } catch (HibernateException e){
        manejaExcepcion(e);
        throw e;
    } finally {
        mSession.close();
    }
    return conductor;
}