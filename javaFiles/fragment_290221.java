// There's some books, insert them into task_items with taskId
rs = query.executeQuery();
query = conn
            .prepareStatement("INSERT INTO task_items"
                    + "(TASK_ID, BOOK_ID, TITLE, AUTHOR)"
                    + "VALUES"
                    + "(?, ?, ?, ?)");

    while (rs.next()) {
        query.setInt(1, taskId);
        query.setInt(2, rs.getInt("ID"));
        query.setString(3, rs.getString("TITLE"));
        query.setString(4, rs.getString("AUTHOR"));         

        query.addBatch();
    }

    System.out.println("executing batch...");

    query.executeBatch();

    System.out.println("batch executed");
    query.close();

    ...