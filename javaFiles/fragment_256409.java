List<Customer> customers = AuditReaderFactory
.get( entityManager )
.createQuery()
.forRevisionsOfEntity( Customer.class, false, true )
.add( AuditEntity.id().eq( 1L ) )
.add( AuditEntity.property( "lastName" ).hasChanged() )
.getResultList();