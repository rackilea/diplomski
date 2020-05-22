// After executing the query
rs.next();
System.out.println(rs.getString("TYPE_LEAVES.NAME"));
System.out.println(rs.getString("TYPE_APPLICATIONS.NAME"));

// Prints:
// leave type 1
// application type 1