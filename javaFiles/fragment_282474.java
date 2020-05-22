//making the method name more generic
public List<E> getData() {   
    Session session = hibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    tx.begin();
    List<E> result = new ArrayList<E>();

    // try to add a model final static field which could retrieve the 
    // correct value of the model. 
    Query query = session.createQuery("from " + E.model);
    result = (List<E>) query.list();
    return result;
}