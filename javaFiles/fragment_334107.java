private Set<ResultSet> executeProcedure(final String sql)
{
    return jdbc.execute(new CallableStatementCreator() {
        @Override
        public CallableStatement createCallableStatement(Connection con) throws SQLException
        {
            return con.prepareCall(sql);
        }
    }, new CallableStatementCallback<Set<ResultSet>>() {
        @Override
        public Set<ResultSet> doInCallableStatement(CallableStatement cs) throws SQLException
        {
            Set<ResultSet> results = new HashSet<>();

            boolean resultsAvailable = cs.execute();

            while (resultsAvailable)
            {
                results.add(cs.getResultSet());
                resultsAvailable = cs.getMoreResults();
            }
            return results;
        }
    });
}