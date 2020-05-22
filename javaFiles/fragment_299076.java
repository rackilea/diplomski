catch (SQLException ex) {
    // Release Connection early, to avoid potential connection pool deadlock
    // in the case when the exception translator hasn't been initialized yet.
    DataSourceUtils.releaseConnection(con, getDataSource());
    con = null;

    // create the translated exception
    Exception et = getExceptionTranslator().translate("ConnectionCallback", getSql(action), ex);

    // throw the translated exception
    throw et;
}
finally {
     // release the connection.
     // If a SQLException is caught above, then this will run before 
     // the translated exception is thrown to the caller
     DataSourceUtils.releaseConnection(con, getDataSource());
}