// Remove a cat and update the other entities
    Session s = sessionFactory.openSession();
    s.beginTransaction();
    s.delete(c);
    for (UC uc : c.getOwned())
        uc.getUser().getOwned().remove(uc);
    s.update(u);
    s.getTransaction().commit();
    s.close();