Statement stmt = ...;
stmt.setFetchSize(100);
ResultSet rs = ...;
rs.next(); // Triggers fetch of 100 rows, positions on row 1 / 100
rs.next(); // Positions on row 2 / 100
// 3-99 rs.next();
rs.next(); // Positions on row 100 / 100
rs.next(); // Triggers fetch of 100 rows, positions on row 101 / 200
// etc