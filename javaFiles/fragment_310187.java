<appender name="DB" class="org.apache.log4j.jdbc.JDBCAppender">
    <param name="URL" value="jdbc:sqlserver://notarealserver;databaseName=notarealdatabase"/>
    <param name="driver" value="com.microsoft.sqlserver.jdbc.SQLServerDriver"/>
    <param name="user" value="notarealuser"/>
    <param name="password" value="notarealpassword"/>
    <param name="sql" value="insert into [dbo].[Log] values('%x', '%d','%C','%p','%m')"/>           
<layout class="org.apache.log4j.PatternLayout"></layout>
</appender>