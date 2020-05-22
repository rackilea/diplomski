connection.setAutoCommit(false);
// check if number exists
// increment if it does
// insert if it doesn't
// commit, rollback & repeat in case of error
connection.setAutoCommit(true);