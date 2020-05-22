try {
    // JDBC code
}
catch (SQLException e) {
    // try to solve the exception at API level
    bollean solvable = trySolveException(e);
    if (!solvable) {
        // Alert the admin, or log the error statement for further debugging.
        mailClient.sendMailToDBAdmin("Some issue storing password", e); 
        // or
        LOG.severe("some issue in storing password " + e.toString);
        throw MyException("A request/logstatement is logged on your behalf regarding the exception", e);
    }
    LOG.info("The exception is solved");
}
finally {
    // don't forget to free your resources - to avoid garbage and memory leaks, incase you have solved the issue in trySolveException(e).
}