// define your embeddable class attributes
final PeriodicityId id = new PeriodicityId();
id.setInstrumentId( instrumentId );

// lookup revision 1
final Number revisionId = 1; 

// query
final AuditReader auditReader = AuditReaderFactory.get( session );
auditReader.find( Periodicity.class, id, revisionId );