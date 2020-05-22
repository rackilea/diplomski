public static void insertChild(Parent p, Child c) {
    Session session = SessionContainer.factory.openSession();
    Transaction tx = null;

    try {
        tx = session.beginTransaction();
        Query query = session.createQuery("FROM com.mycompany.dvnfsscce.Parent p WHERE p.id = :id_parent");

        query.setParameter("id_parent", p.getId());

        List results = query.list();
        Parent parent = (Parent)results.get(0);

        // Here we set the id.
        c.setIdParent(parent.getId());

        List<Child> finalList = parent.getChildren();
        finalList.add(c);
        parent.setChildren(finalList);

        session.update(parent);

        tx.commit(); //crashpoint
    } catch(HibernateException he) {
        if (tx != null) tx.rollback();
        he.printStackTrace();
    } finally {
        session.close();
    }
}