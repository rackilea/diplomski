<Resource
        name="jdbc/g"
        auth="Container"
        type="javax.sql.DataSource"
        driverClassName="oracle.jdbc.OracleDriver"
        url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
       factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
        username="root"
        password="root"
        maxActive="20"
        validationQuery="SELECT 1 FROM DUAL;"
        testOnBorrow="true"
        maxIdle="10"
        maxWait="-1"/>