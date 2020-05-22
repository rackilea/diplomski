public List<WlascicieleEntity> listWlasciciele() {

    Session session = HibernateUtil.openSession();
    session.beginTransaction();
    List<WlascicieleEntity> list = session.createQuery(
        "select distinct w from WlascicieleEntity w"
        + " left join fetch w.telefonyEntities").list();
    session.getTransaction().commit();
    session.close();

    return list;
}