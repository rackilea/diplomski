public void updateDatabase() throws Exception {

    PreparedStatement updateStmt = null;
    String updateString = "some sql code";

    // save point to roll back to... 
    Savepoint savepoint = con.setSavepoint();    

    try {
        // disable auto commit
        con.setAutoCommit(false);
        updateStmt = con.prepareStatement(updateString);

        updateStmt.executeUpdate();

        // call instructions
        instruction1();
        instruction2();

        // if we get here then all is good, commit
        con.commit();

    } catch (Exception e ) {
        // if we get here then instruction 1 or 2 failed... rollback
        if (con != null) {
            try {
                System.err.print("Transaction is being rolled back");
                con.rollback(savepoint);
            } catch(SQLException excep) {
                // log error
            }
        }
    } finally {
        if (updateStmt != null) {
            updateStmt.close();
        }
        // set connection back to auto-commit
        con.setAutoCommit(true);
    }
}