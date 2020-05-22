<Context antiJARLocking="true" path="/poll" >

    <Resource name="jdbc/PollDatasource" auth="Container" type="javax.sql.DataSource"
     driverClassName="org.apache.derby.jdbc.ClientDriver"
     url="jdbc:derby://localhost:1527/poll database;create=true"
     username="suhail" password="suhail"
     maxActive="20" maxIdle="10" maxWait="-1" />

</Context>