mks.dynamicPool.config=\
url=jdbc:jtds:sqlserver://[yourmachinehost]:[SQL Server port]/[yourdatabase name];useCursors=true,\
driver=mks.frame.sql.jdbc.mssql.Driver,\
initialCapacity=5,\
maxCapacity=100,\
testTable=VersionIdentity
mks.dbUser=user1
mks.dbPassword=user1