em.getTransaction().begin();

    ...some changes to data object...
    em.merge(data);
    em.flush();

    em.getTransaction().commit();