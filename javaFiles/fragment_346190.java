<library id="DB2JCC4Lib">
    <fileset dir="${wlp.install.dir}/lib" 
        includes="db2jcc.jar db2jcc_license_cisuz.jar db2jcc_license_cu.jar"/>
</library>
<dataSource id="db2_SUD" jndiName="jdbc/U_SUD">
    <jdbcDriver libraryRef="DB2JCC4Lib"/>
    <properties.db2.jcc databaseName="DB2TEST" password="YYYYY" portNumber="20025"
        serverName="xyxyxyxxyx" user="XXXXX" progressiveStreaming="2"/>
</dataSource>