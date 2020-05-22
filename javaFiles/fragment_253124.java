CallableStatement cstmt;
ResultSet rs;
int i;
String s;
...
cstmt.execute();                        // Call the stored procedure       1 
rs = cstmt.getResultSet();              // Get the first result set        2 
while (rs.next()) {                     // Position the cursor             3 
 i = rs.getInt(1);                      // Retrieve current result set value
 System.out.println("Value from first result set = " + i);  
                                        // Print the value
}
cstmt.getMoreResults();                 // Point to the second result set  4a 
                                        // and close the first result set
rs = cstmt.getResultSet();              // Get the second result set       4b 
while (rs.next()) {                     // Position the cursor             4c 
 s = rs.getString(1);                   // Retrieve current result set value
 System.out.println("Value from second result set = " + s); 
                                        // Print the value
}
rs.close();                             // Close the result set
cstmt.close();                          // Close the statement