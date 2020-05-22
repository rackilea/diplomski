try(Connection con = ds.getConnection()){
   con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
   con.setAutoCommit(false);
   //...
} catch(SQLException sqle) {
   throw new MyModelException(e)
}