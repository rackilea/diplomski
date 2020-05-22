CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<News> cq = cb.createQuery(News.class);
Root<News> news = cq.from(News.class);
List<Predicate> predicates = new ArrayList<Predicate>();

if (!parameters.get("author").isEmpty()) {
    predicates.add(cb.in(news.get("author"), parameters.get("author")));
}

// Other params here.

cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()]));
TypedQuery<News> query = em.createQuery(cq);
return query.getResultList();