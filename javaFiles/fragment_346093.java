// for all three it works the same way (as a note the 'system' keyspace cant 
// be modified by users so below im using a keyspace name 'exampkeyspace' and
// a table (or columnfamily) called users

String cqlStatementC = "INSERT INTO exampkeyspace.users (username, password) " + 
                      "VALUES ('Serenity', 'fa3dfQefx')";

String cqlStatementU = "UPDATE exampkeyspace.users " +
                      "SET password = 'zzaEcvAf32hla'," +
                      "WHERE username = 'Serenity';";

String cqlStatementD = "DELETE FROM exampkeyspace.users " + 
                      "WHERE username = 'Serenity';";

session.execute(cqlStatementC); // interchangeable, put any of the statements u wish.