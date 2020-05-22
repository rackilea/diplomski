int doPingDatabase() throws SQLException {
    Statement var1 = null;

    byte var3;
    try {
        var1 = this.createStatement();
        ((oracle.jdbc.OracleStatement)var1).defineColumnType(1, 12, 1);
        var1.executeQuery("SELECT \'x\' FROM DUAL");
        return 0;
    } catch (SQLException var7) {
        var3 = -1;
    } finally {
        if(var1 != null) {
            var1.close();
        }

    }

    return var3;
}