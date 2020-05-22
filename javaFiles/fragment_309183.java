Statement stmt = conn.createStatement();
String sqlCommand = "DROP TABLE IF EXISTS 'myDatabase.myTable' ";

System.out.println("output : " + stmt.executeUpdate(sqlCommand));

stmt.close();
conn.commit();     // commit after execute sql command
                //COMMIT TRANSACTION makes all data modifications performed since 
                //the start of the transaction a permanent part of the database, 
conn.close();