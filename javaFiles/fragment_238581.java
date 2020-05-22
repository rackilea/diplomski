@Transactional
public void save(Administrator entity) {
   Session session = getSessionFactory().getCurrentSession();
   entity.setNewSecretCode();
   session.save(entity);
}