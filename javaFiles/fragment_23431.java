public int insertValues(Collection<String> params){
    int i = 0;
    for (String param : params){
        statement.setString(++i, param);
    }
    return statement.executeUpdate();
}