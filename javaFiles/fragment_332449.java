List<String> dbColumns = Arrays.asList("firstname", "lastname", "username", "email", "mobilenumber", "dateJoined");

CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Client> cq = cb.createQuery(Client.class);
Root<Client> entity = cq.from(Client.class);
cq.select(entity);

List<Predicate> predicates = new ArrayList<Predicate>();
if(params.containsKey("search") && StringUtils.isNotBlank(search)){
    String search = String.valueOf(params.get("search"));
    List<Predicate> ORPredicates = new ArrayList<Predicate>();
    for(String column : dbColumns){
        Path<Tuple> tuple = entity.<Tuple>get(column);
        if(tuple.getJavaType().isAssignableFrom(Date.class)){
            Expression<String> dateStringExpr = cb.function("DATE_FORMAT", String.class, entity.get(column), cb.literal("'%d/%m/%Y %r'"));
            ORPredicates.add(cb.like(cb.lower(dateStringExpr), "%"+search.toLowerCase()+"%"));
        }else{
            ORPredicates.add(cb.like(cb.lower(entity.get(column).as(String.class)), "%"+search.toLowerCase()+"%")); 
        }
    }
    predicates.add(cb.or(ORPredicates.toArray(new Predicate[]{})));
}

cq.where(predicates.toArray(new Predicate[]{}));
TypedQuery<Client> query = em.createQuery(cq); //<--- Error gets thrown here
return query.getResultList();