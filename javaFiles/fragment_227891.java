REXP y = re.eval("sql_data <- try(dbGetQuery(conn, \"" + SQL_command + "\"),silent=TRUE)");
       REXP x = re.eval("class(sql_data)");
       if ((x.asString()).equals("try-error")) {
          System.out.println(y.asString());
          // do something to catch the exception
       } else {
         // do normal stuff
       }