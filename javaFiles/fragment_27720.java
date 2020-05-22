public void doSomething() throws Exception {
    em.getTransaction().begin();

    try {
        em.createQuery("DELETE FROM something WHERE something = something").executeUpdate();
    } catch(Exception e) {
        em.getTransaction().setRollbackOnly();
    } finally {
        em.getTransaction().commit();
    }
}