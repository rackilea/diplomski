public Customer getBestCustomerOfMonth() {
EntityManagerFactory emf = ... ;
EntityManager em = emf.createEntityManager();
// business logic
em.close();
}