new FunctionalStuff<MyRecord>() {
    @Override
    public void execute(DatabaseOperator databaseOperator, MyRecord r) throws Exception {
        databaseOperator.updateInfo(r);
    }
});