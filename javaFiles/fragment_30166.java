KeyHolder holder = new GeneratedKeyHolder();
PreparedStatementCreator creator = new PreparedStatementCreator() {
    @Override
    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement insertStatement = con.prepareStatement(INSERT_OBJECT_DETAILS, new Object[] { 
                               employeeObject.getEmployeeId(),
                               employeeObject.getFirstName(), 
                               employeeObject.getLastName()}));
        return insertStatement;
    }
};
getJdbcTemplate().update(creator, holder);
System.out.println(holder.getKey());