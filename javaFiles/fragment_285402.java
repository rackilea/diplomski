queryStr = "SELECT e FROM DeSiteUser e " + queryStr;
String queryStr = " WHERE e.deactivationTime = '9999-12-31 00:00:00.000' ";
if (clientId != null) {
    queryStr += String.format("AND e.userId IN (SELECT id FROM DeUser u WHERE ");
    queryStr += String.format("u.clientId = %d ", clientId);
    queryStr += " ) ";
}