public void persist(Msg message) {
    LOG.info("\t" + message);
    LOG.info("isOpen?" + em.isOpen());
    em.getTransaction().begin();
    int id = message.getId();
    TypedQuery<Note> q = em.createQuery("SELECT  n "
            + "FROM Notes n WHERE n.messageId = :messageId "
            + "AND n.group = :group", Note.class);
    q.setParameter("messageId", id).setParameter("group", group);
    List<Note> results = q.getResultList();
    em.getTransaction().commit();
    for (Note o : results) {
        LOG.info("object is \n\n" + o);
    }
}