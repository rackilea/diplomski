If you don't have the right Oracle driver in the classpath in Class.forName:
Exception in thread "main" java.lang.ClassNotFoundException: oracle.jdbc.driver.OracleDriver

If DriverManager.getConnection fails because of a wrong jdbc url syntax:
Exception in thread "main" java.sql.SQLException: No suitable driver found for jdbc:oracle...

If login/password fails at DriverManager.getConnection
Exception in thread "main" java.sql.SQLException: ORA-01017: invalid username/password; logon denied

In case of an incorrect SQL statement:
Exception in thread "main" java.sql.SQLSyntaxErrorException: ORA-00942: table or view does not exist

In case of an incorrect SQL statement:
Exception in thread "main" java.sql.SQLSyntaxErrorException: ORA-00900: invalid SQL statement

In case of an incorrect SQL statement:
Exception in thread "main" java.sql.SQLException: Invalid column name