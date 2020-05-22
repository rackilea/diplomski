Statement createStatement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet executeQuery = createStatement.executeQuery("select id, name from stu");       
        executeQuery.afterLast();
        while (executeQuery.previous()) {   
            int rollno = executeQuery.getInt("id");
            System.out.println("rollno " + executeQuery.getString("id") + " name " + executeQuery.getString("name"));
            if (rollno == 1) {
                executeQuery.updateString("NAME", "new value");
                executeQuery.updateRow();
            }
        }