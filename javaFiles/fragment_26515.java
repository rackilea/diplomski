public void insereMesa(Mesa m){
    EntityTransaction et = em.getTransaction();
    et.begin();
    em.persist(m);
    et.commit();
}