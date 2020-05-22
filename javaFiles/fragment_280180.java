public void insert(String type)
    Session s= dao.getCurrentSession();
    Long id=dao.getId();
    Long typeId=(Long)s.createQuery("select typeId from table2 where type =?").
            .setParameter(0, type,  Hibernate.String)
            .uniqueResult();

    if(typeId==null){
       Table2 t=new Table2(type);
       typeId=(Long)s.save(t);
       s.flush();
    }
    s.createQuery("insert into table1 t (id,msg,Table2")) VALUES (?,?,?)
        .setParameter(0, id,      Hibernate.Long)
        .setParameter(1, "msg",   Hibernate.String)
        .setParameter(2, typeId,  Hibernate.Long)
        .executeUpdate();
        s.flush();
}