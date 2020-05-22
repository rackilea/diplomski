statement = connection.prepareCall("CALL_TEST_NUMBER(?)");
statement.registerOutParameter("val", java.sql.Types.INTEGER);
statement.execute();
statement.getInt("val");       // 2
statement.getDouble("val");    // 2.5
statement.getString("val");    // "2.5"

statement = connection.prepareCall("CALL TEST_TEXT(?)");
statement.registerOutParameter("val", java.sql.Types.INTEGER);
statement.execute();   //  java.sql.SQLSyntaxErrorException: ORA-01722: invalid number