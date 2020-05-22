TypedQuery<Picture> q = em.createQuery("select p from Picture p where p.dateCreated < :date order by p.dateCreated desc", Picture.class);
    q.setParameter("date", date, TemporalType.TIMESTAMP);

    List<Picture> pictures = q
            .setMaxResults(1)
            .getResultList();