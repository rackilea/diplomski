List<Long> list = null;

    try{
        Session session = sessionFactory.getCurrentSession();

        Query query = session.getNamedQuery("endDateChecker");
        list =  query.list();


        Query query1 = session.getNamedQuery("updateINFO")
                    .setParameterList("parameters",list);

        query1.executeUpdate();



    }catch (HibernateException e){
        throw new DataAccessException(e.getMessage());
    }
    return list;
}