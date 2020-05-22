stmt.execute("SET sql_mode = ''");

 for (int i = 0; i < loadinhcc.length; i++) {

      stmt.execute(loadinhcc[i]);
 }