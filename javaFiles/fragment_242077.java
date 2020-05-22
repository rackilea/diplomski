queryB.append("select * from TABLE_NAME where REASON = ? AND TASK = ? AND RESULT = ?");
if (!(resultCause.isEmpty())) {
    queryB.append(" AND RESULT_CAUSE = ?");
}
prepStmt= connection.prepareStatement(queryB);

prepStmt.setString(1, reason);
prepStmt.setString(2, task);
prepStmt.setString(3, result);

if (!(resultCause.isEmpty())) {
   prepStmt.setString(4, resultCause);
}