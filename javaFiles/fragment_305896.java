<Context path="/jspdemo" docBase="jspdemo" debug="0" reloadable="true" crossContext="true">
  <Resource name="jdbc/jspdemo" auth="Container" type="javax.sql.DataSource" maxActive="20" 
    maxIdle="10" maxWait="1000" username="informix"  password="mypasswd" 
    driverClassName="com.informix.jdbc.IfxDriver" 
    url="jdbc:informix-sqli://mymachine:1526/stores_demo:INFORMIXSERVER=ol_myserver;IFX_LOCK_MODE_WAIT=60;/>
</Context>