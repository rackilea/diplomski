// Mapped in routes file as GET /exception        
public static void exceptionTest() {
    RuntimeException e = new RuntimeException("This is a test");
    logException(e);
    renderText("You are here");

}

private static void logException(RuntimeException e) {
    EntityManager em = JPA.newEntityManager();
    Notification n = new Notification();
    n.setMessage(e.getMessage());

    em.getTransaction().begin();
    em.persist(n);
    em.getTransaction().commit();
    throw e;
}