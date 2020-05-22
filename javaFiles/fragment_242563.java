public class AuditListener implements PostInsertEventListener {
  private static final long serialVersionUID = -966368101369878522L;

  @Override
  public void onPostInsert(PostInsertEvent event) {
    if (event.getEntity() instanceof Auditable) {
      Session session = null;
      try {
        session = event.getPersister().getFactory().getCurrentSession();
        Auditable auditableEntity = (Auditable)event.getEntity();
        session.save(new AuditTrail(auditableEntity.getClass().getSimpleName(),
            auditableEntity.getId(), auditableEntity.getStatus(),
            auditableEntity.getLastModified()));
      } catch (HibernateException he) {
        System.out.println("Horrible error: " + he.getMessage());
        session.getTransaction().rollback();
      }
    }
  }
}