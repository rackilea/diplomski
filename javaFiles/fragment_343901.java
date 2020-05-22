public void importTargetValue(NumberImportData data, Target target, ImportType type) throws SQLException {      
    List<Statement> stmtList = new ArrayList<Statement>();

    Connection conn = null;
    PreparedStatement stmtTarget = null;
    PreparedStatement stmtNumber = null;
    PreparedStatement stmtTargetNumber = null;

    try {
        conn = getConnection();     
        Long returnedTargetId = insertTarget(conn, stmtTarget, target);

        for (TargetNumber t : data.getNumbers()) {
            Long returnedNumberId = insertNumber(conn, stmtNumber, t);
            //insert to decompozition
            insertTargetNumber(conn, stmtTargetNumber, returnedTargetId, returnedNumberId);
        }

    } finally {
        stmtList.add(stmtTarget);
        stmtList.add(stmtNumber);
        stmtList.add(stmtTargetNumber);
        closeDbResources(conn, stmtList);
    }               
}