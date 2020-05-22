Connection connection = DriverManager.getConnection(
"jdbc:xmla: Server=http://192.168.0.151/OLAP/msmdpump.dll;" +
"Data Source=http://192.168.0.151/OLAP/msmdpump.dll;" +
"Initial Catalog=AdventureWorksDW2014; " +
"Integrated Security=Basic; " +
"User ID=XXX; " +
"Password=XXX;");