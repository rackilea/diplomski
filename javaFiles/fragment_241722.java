public static AuditProperty<RevisionType> revisionType() {
  return revisionType( null );
}

public static AuditProperty<RevisionType> revisionType(String alias) {
  return new AuditProperty<>( alias, new RevisionTypePropertyName() );
}