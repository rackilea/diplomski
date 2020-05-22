public List<Auftrag> findByFilter(Long id) { 
  Criteria criteria = session.createCriteria(Auftrag.class);
  if (id != null) {
    criteria.add(Restrictions.eq("id", id));
  } // if
  return criteria.list();
}