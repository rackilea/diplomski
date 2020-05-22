public void executeSqlStatement(String sqlStatement) throws Exception {

    PreparedStatementCreator statement = new PreparedStatementCreator() {
        @Override
        public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
            List<String> params = new ArrayList<>();
            if (sqlStatement.length() >= 4000) {
                Pattern pattern = Pattern.compile("'(([^'\n]|'')+)'");
                Matcher m = pattern.matcher(sqlStatement);
                StringBuffer sb = new StringBuffer();
                while (m.find()) {
                    params.add(m.group(1).replace("''", "'"));
                    m.appendReplacement(sb, "?");
                }
                m.appendTail(sb);
                sqlStatement = sb.toString();
            }
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            for (int i = 0; i < params.size(); ++i) {
                statement.setString(1 + i, params[i]);
            }
            return statement;
        }
    };
    getJdbcTemplate().update(statement);
}