AuditReader reader = AuditReaderFactory.get(entityManager);
AuditQuery query = reader.createQuery()
.forRevisionsOfEntity(Booking.class, false, true)
.add(AuditEntity.revisionProperty("timestamp").gt(timestamp)
.add(AuditEntity.revisionType().eq(RevisionType.DEL));

List<Object[]> results = query.getResultList();