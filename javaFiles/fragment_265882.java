ConnectionHelper connectionHelper = new ConnectionHelper();
                    CallableStatement callableStatement;
             try {
                    callableStatement = connectionHelper.getConnection().prepareCall("{call MySP(?, ?, ?)}");
                    callableStatement.setInt(1, X);
                    callableStatement.setInt(2, X));
                    callableStatement.setInt(3, X);
                    callableStatement.executeUpdate();

                    } catch (SQLException e) {
                      //this is a specific SQL exception
                      e.printStackTrace();

                   }
                  catch (Exception e) {
                      //all other exceptions except the one above
                      //here you do your toast message

                   }