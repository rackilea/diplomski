Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "postgres");

CallableStatement callableStatement = conn.prepareCall("{call f_raise_wage_employee_older_than(?,?)}");
callableStatement.setInt(1, 20);
callableStatement.setInt(2, 500);
callableStatement.executeUpdate();