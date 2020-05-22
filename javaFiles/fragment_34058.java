public void persistArticle(Message message, Folder folder) {
    em.getTransaction().begin();
    try {
        // your code goes here; possibly current body of persistArticle(..)

        em.getTransaction().commit();
    } catch (final RuntimeException e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }

        throw e;
    }
}