Statement statement = connection.createStatement();
    String queryParam = "Computers"
    String sqlQuery = "select employee_id,first_name,last_name from dfs.'employee.json' where department LIKE'" +queryParam +"'"+"and conditions<...> ";
    ResultSet rs = statement.executeQuery(sqlQuery);
                while(rs.next)
               {
                 do as you need
                }