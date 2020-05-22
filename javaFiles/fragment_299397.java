public Contact find(Long id) {
        TypedQuery<Contact> query = em.createQuery(
        "SELECT c FROM Contact c join fetch c.address WHERE c.id = :id", Contact.class);
         return query
           .setParameter("id", id)
           .getSingleResult();
    }