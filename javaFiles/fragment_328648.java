String table = "Murder_PlayerData"
String strSQL = "create table if not exists " + table + "("
                 // Add your column definitions
              + ")"
Statement stmt = conn.createStatement();
stmt.execute(strSQL);