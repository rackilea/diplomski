try {
     con.setAutoCommit(false);

     dbConnector.insertClient(...
     dbConnector.insertPortfolio(...
     dbConnector.insertClientFees(...

     con.commit();
} catch(SQLException e) {
     try {
          con.rollback();
          e.printStackTrace();
           return "Failed to save data. Data safely rolled back";
     } 
     ...
}