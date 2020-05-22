...
EntityManager em = this.getEntityManagerFactory().createEntityManager(props);

em.getTransaction().begin();
em.getTransaction().commit();

Query query = em.createNamedQuery("Plant.getPlantById");
...