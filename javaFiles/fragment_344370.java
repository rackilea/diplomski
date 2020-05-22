EntityManager em = entityManager();
// Retrieve the expert in the new EntityManager context 
Expert expertToDelete = em.find(Expert.class, anExpert.id);

em.getTransaction().begin();
expertToDelete.getProduct().getExperts().remove(expertToDelete);
expertToDelete.getPerson().getExperts().remove(expertToDelete);
em.remove(expertToDelete);
em.getTransaction().commit();