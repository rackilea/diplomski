public Integer search(HashMap<String, Object> params) {
    Session sesion = sessionFactory.openSession();
    Integer id = null;
    //get the transaction object:
    Transaction tx = sesion.beginTransaction();
    try{
        //a new restriction added to the search:
        Criteria criteria = sesion.createCriteria(User.class);
        criteria.add(Restrictions.eq("name", (String)params.get("name")));
        criteria.add(Restrictions.eq("email", (String)params.get("email")));
        List lista = criteria.list();
        //commit:
        tx.commit();
        //only one should be found, this is yet to be implemented:
        if(lista.size() == 1){id = ((User)lista.get(0)).getId();}
    }catch(HibernateException he){
        //in case of an exception thrown while committing, roll back transaction:
        tx.rollback();
        he.printStackTrace();
    }finally{sesion.close();}
    return id;
}