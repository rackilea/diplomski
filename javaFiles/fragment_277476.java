} catch (SQLException ex) {
  final String ss = ex.getSQLState();
  if (ss.equals("40001") || ss.equals("40P01")) {      
     /* It is a serialization failure or a deadlock abort. Retry the tx. */
     retry_transaction = true;
  } else if (ss.startsWith("08") || ss.startsWith("53")) {
     /* It is a connection error or resource limit. Reconnect and retry. */
     try {
        conn.close();
     } catch (SQLException ex) { 
        logger.log("Error closing suspected bad connection after SQLState " + ss, ex);
     }
     conn = null; /* App knows to reconnect if it sees a null connection */
     retry_transaction = true;
  } else {
     throw new MyAppException(ex);
  }
}