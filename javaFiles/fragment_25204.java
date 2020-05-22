@Transient
public static Collection<?> searchResults(JsonJqgridSearchModel jsonJqgridSearchModel){
    HibernateEntityManager hem = Person.entityManager().unwrap(HibernateEntityManager.class);
    Session session = hem.getSession();
    Criteria criteria = session.createCriteria(Person.class);
    Iterator<JqgridSearchCriteria> iterator = jsonJqgridSearchModel.rules.iterator();
        while(iterator.hasNext()){  
            criteria.add(iterator.next().getRestriction());
        }
    return criteria.list();     
}