@Override
public List<MyEntity> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {

    List<MyEntity> list;

    Query q = em.createQuery(this.queryText);

    // Paginate
    q.setFirstResult(first); 
    q.setMaxResults(pageSize); 
    list = query.getResultList();

    return list.subList(0,list.size());
}