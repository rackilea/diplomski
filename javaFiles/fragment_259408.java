public void executeAll(String queryString) throws SQLException {
    boolean hasMoreResults = statement.execute(queryString);
    int updateCount = statement.getUpdateCount();

    while(hasMoreResults || (!hasMoreResults && updateCount != -1)){
        //.execute() can be false if a query is not returned as when using a SET/ UPDATE/ DELETE which is why we check if updateCount is -1 meaning there are no more statements returned
        if(hasMoreResults){
            resultSet = statement.getResultSet();
            //Do what you need to do with the ResultSet
        } else {
            //Else it's a UPDATE/ DELETE count - int
            //Do what you need to do with the updateCount
        }
        hasMoreResults = statement.getMoreResults();
        updateCount = statement.getUpdateCount();
        //New values for the next cycle
    }
    //Possibly return stuff?
}