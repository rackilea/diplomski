String sql = "{call DBMS_SCHEDULER.RUN_JOB(?)}";

      try (Connection conn = dataSource.getConnection(); 

              CallableStatement stmt = conn.prepareCall(sql);) {

                 //Set IN parameter
                 stmt.setString(1, "CTI_QUEUEHANDLER");

                 //Execute stored procedure
                 stmt.execute();

      } catch (SQLException e) {
         e.printStackTrace();
      }