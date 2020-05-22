@SuppressWarnings("unchecked")
@Transactional
public Collection<Entry> findEntries() {
    return sessionFactory.getCurrentSession()
      .createCriteria(Entry.class)
      .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
      .list();
}