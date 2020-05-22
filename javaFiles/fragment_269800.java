@PersistenceContext 
EntityManager em;

@Transactional 
public List<Person> listPerson() { 
    CriteriaQuery<Person> c = em.getCriteriaBuilder().createQuery(Person.class); 
    Root<Person> from = c.from(Person.class); 

    c.select(from);
    c.where(em.getCriteriaBuilder().equal(from.get("owner_email"),"john@gmail.com")); // <- this will add the restriction. 

    c.orderBy(em.getCriteriaBuilder().asc(from.get("firstname"))); 
    return em.createQuery(c).getResultList(); 
}