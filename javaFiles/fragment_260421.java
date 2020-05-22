Connection conn = getConnection();

DatabaseMetaData mtdt = conn.getMetaData();
System.out.println("DBMS name: " + mtdt.getDatabaseProductName());
System.out.println("DBMS version: " + mtdt.getDatabaseProductVersion());
System.out.println("Driver name: " + mtdt.getDriverName());