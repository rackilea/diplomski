template.execute("SET NUM_NODES = 1"); //template is JDBCTemplate

String query = "insert into employee (ID,NAME,AGE,ADDRESS,SALARY) VALUES (1, 'Ramesh', 32, 'Mumbai', 20000 )";

template.execute(query); //template is JDBCTemplate

template.execute("SET NUM_NODES = 0"); //template is JDBCTemplate