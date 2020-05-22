String Id = "123";
String result;
Connection conn = null;
CallableStatement scs = null;
ResultSet resultSet = null;
try {
            conn = getDatabaseConnection();
            String query = "select db.getData(?) ";
            scs = conn.prepareCall(query);
            //Set of parameters
            scs.setString(1, Id);
            //Execution
            resultSet = scs.executeQuery();
            while (resultSet.next()) {
                //Get the result
                result = resultSet.getString(1);
            }