public T create(T entity) {
  em.persist(entity);
  em.flush();
  em.refresh(entity); // this could be important
  return entity;
}