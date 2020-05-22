public List<T> getSomeValue(String[] parameters, ResultSetMapper<T> mapper) {
    try {
        //Get connection from pool
        //Execute procedure
        //Process resultset
        return mapper.convert(resultSet);  
    } catch (SomeException e) {
        //Error handling mechanism
    } finally {
        //Release connection
    }
}

interface RowMapper<T> {
    List<T> convert(ResultSet resultSet);
}