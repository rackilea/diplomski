final AuditReader auditReader = AuditReaderFactory.get( session );
List results = auditReader.createQuery()
  .forRevisionsOfEntity( Periodicity.class, true, false )
  // add the revision number predicate
  .add( AuditEntity.revisionNumber().eq( revisionId ) )
  // add the instrument predicate
  .add( AuditEntity.property( "id.instrumentId" ).eq( instrumentId ) )
  .getResultList();