public static final DatabaseOperation SEQUENCE_RESETTER_POSTGRES = new DatabaseOperation() {
    @Override
    public void execute(IDatabaseConnection connection, IDataSet dataSet)
            throws DatabaseUnitException, SQLException {
        String[] tables = dataSet.getTableNames();
        Statement statement = connection.getConnection().createStatement();
        for (String table : tables) {
            int startWith = dataSet.getTable(table).getRowCount() + 1;
            statement.execute("alter sequence " + table + "_PK_SEQ RESTART WITH "+ startWith);

        }
    }
};

public static final DatabaseOperation SEQUENCE_RESETTER_ORACLE = new DatabaseOperation() {
    @Override
    public void execute(IDatabaseConnection connection, IDataSet dataSet)
            throws DatabaseUnitException, SQLException {
        String[] tables = dataSet.getTableNames();
        Statement statement = connection.getConnection().createStatement();
        for (String table : tables) {
            int startWith = dataSet.getTable(table).getRowCount() + 1;
            statement.execute("drop sequence " + table + "_PK_SEQ if exists");
            statement.execute("create sequence " + table + "_PK_SEQ START WITH " + startWith);
        }
    }
};