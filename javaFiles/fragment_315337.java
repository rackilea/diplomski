C:\dev\java8\quick_java_mysql_test>java -cp ".;dep/mysql-connector-java-5.1.35-bin.jar" myTest

------------------------------
5.6.24-log
------------------------------
Oct 17, 2015 11:35:25 AM myTest main
SEVERE: Table 'so_gibberish.thingws' doesn't exist
com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table 'so_gibberish.thingws' doesn't exist
        at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)
        at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)
        at java.lang.reflect.Constructor.newInstance(Unknown Source)
        at com.mysql.jdbc.Util.handleNewInstance(Util.java:389)
        at com.mysql.jdbc.Util.getInstance(Util.java:372)
        at com.mysql.jdbc.SQLError.createSQLException(SQLError.java:980)
        at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3835)
        at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3771)
        at com.mysql.jdbc.MysqlIO.sendCommand(MysqlIO.java:2435)
        at com.mysql.jdbc.MysqlIO.sqlQueryDirect(MysqlIO.java:2582)
        at com.mysql.jdbc.ConnectionImpl.execSQL(ConnectionImpl.java:2531)
        at com.mysql.jdbc.ConnectionImpl.execSQL(ConnectionImpl.java:2489)
        at com.mysql.jdbc.StatementImpl.executeQuery(StatementImpl.java:1446)
        at myTest.main(myTest.java:31)