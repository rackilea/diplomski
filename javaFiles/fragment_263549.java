Connection conn = null;
try {
    // getConnection from pool

    conn.setAutoCommit(false);

    EmployeeDAO employeeDAO = new EmployeeDAO();
    employeeDAO.setConnection(conn);

    BankDAO bankDAO = new BankDAO();
    bankDAO.setConnection(conn);

    // save employee

    // save bank details

    conn.commit();

catch(Exception e) {
    if (conn != null) {
        conn.rollback();
    }
} finally {
    if (conn != null) {
        conn.close();
    }
}