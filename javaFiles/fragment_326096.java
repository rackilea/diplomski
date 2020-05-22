import java.sql.*;

con2 =  DriverManager.getConnection('jdbc:mysql://localhost/database','root', '  ');
str = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

selectlastdb = 'select * from table order by id desc limit 1';
result = str.executeQuery(selectlastdb);

result.next();

result.updateString('aa', 'hello');
result.updateString('bb', 'bye');

result.updateRow();