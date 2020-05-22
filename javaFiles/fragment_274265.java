public static void main(String[] args) {

    EntityManager em = ... // from EntityManagerFactory, injection, etc.

    em.getTransaction().begin();

    A parent   = new A();
    A son      = new A();
    A daughter = new A();

    son.setParent(parent);
    daughter.setParent(parent);
    parent.setChildren(Arrays.asList(son, daughter));

    em.persist(parent);
    em.persist(son);
    em.persist(daughter);

    em.getTransaction().commit();
}