CriteriaBuilder cb = emf.getCriteriaBuilder();
CriteriaQuery<TradeSearchResult> query = cb.createQuery(TradeSearchResult.class); //type is the entity you want to map to
Root<Trade> r = query.from(Trade.class); //root must be entity from which you can access all data

List<Predicate> predicates = new ArrayList<Predicate>(); //new list of predicates

predicates.add(cb.like(r.join("2ndTableEntityName").<String>get("valuefrom2ndtable"),"value to search for")); 
//get the needed value from 2nd table and map it to the field

query.multiselect(r.get("2ndTableEntityName")).where(predicates.toArray(new Predicate[] {}));
//create the query and execute it
EntityManager em = emf.createEntityManager();
List<TradeSearchResult> results = em.createQuery(query).getResultList();
em.close();
return results; //return results