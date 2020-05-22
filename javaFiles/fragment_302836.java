CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
CriteriaQuery<AuditRecordEntity> criteriaQuery = criteriaBuilder.createQuery(AuditRecordEntity.class);
Root<AuditRecordEntity> root = criteriaQuery.from(AuditRecordEntity.class);

Predicate predicate = criteriaBuilder.equal(root.get("auditAccount").get("accountId"), accountId);
criteriaQuery.where(predicate);

TypedQuery<AuditRecordEntity> query = em.createQuery(criteriaQuery);

return query.getSingleResult();