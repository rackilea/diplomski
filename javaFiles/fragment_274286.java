CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<News> cq = cb.createQuery(News.class);
Root<News> news = cq.from(News.class);

if (!parameters.get("author").isEmpty()) {
    cq.where(cb.in(news.get("author"), parameters.get("author"));
}

TypedQuery<News> query = em.createQuery(cq);
return query.getResultList();