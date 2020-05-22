@NamedQuery(name="MyEntity.findByUser", 
    query="SELECT m FROM MyEntity m WHERE m.owner = :user") // don't put OFFSET or LIMIT here

...

entityManager.createNamedQuery("MyEntity.findByUser") 
.setFirstResult(20) // equivalent to OFFSET
.setMaxResults(5) // equivalent to LIMIT
.getResultList();