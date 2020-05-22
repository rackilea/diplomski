session.beginTransaction();
// Call stored procedure
 session.doWork(connection -> {
                String query;
                query = "{CALL TEST(?,?) }";

                String val = txt_uniquecode.getText();
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.setString(1, val);
                callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
                callableStatement.executeUpdate();

                ResultSet rs = (ResultSet) callableStatement.getObject(2);

                while (rs.next()) {
                    System.out.println(rs.getString("NAME"));
                }

            });
  // end 
    session.getTransaction().commit();
    dbUtilSingleton.closeConnection();