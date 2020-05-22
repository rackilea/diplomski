@Auditing(tableName="AUDIT_TABLE_1")
public void auditableMethod() {
  // logic
}

@Aspect
public void audit(Auditing audit) {
  String table = audit.tableName;
  // do your jdbc logic
}