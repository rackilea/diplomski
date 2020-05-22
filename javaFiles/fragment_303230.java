public Integer search(HashMap<String, Object> params) {
    Session sesion = sessionFactory.openSession();
    Integer id = null;
    try{
        List lista = sesion.createCriteria(User.class).add(
                Restrictions.eq("name",(String)params.get("name"))).list();
        if(lista.size() == 1){id = ((User)lista.get(0)).getId();}
    }catch(HibernateException he){
        he.printStackTrace();
    }finally{sesion.close();}
    return id;
}