PreparedStatement prepStmtMan = createStmt("EMP");
PreparedStatement prepStmtEmp = createStmt("MAN");

private PreparedStatement createStmt(String type) {
    // Create a statement that select data from the WORK_PEOPLE table by TYPE column
    PreparedStatement prepStmt = conn.prepareStatement("SELECT * FROM WORK_PEOPLE WHERE TYPE = ?");

    // Set the specific TYPE to the statement
    prepStmt.setString(1, type);

    return prepStmt;
}