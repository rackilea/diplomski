public void insertAndRollback(Connection connection) {
    try {
        final ArrayList parameters = new ArrayList();

        // Add your parameters to the arraylist
        parameters.add("John");
        parameters.add("Lee");
        parameters.add("Mary");
        parameters.add("Peter");
        parameters.add("Lewis");
        parameters.add("Patrick");

        final String parameterizedQuery = "insert into person (name) values (?)";

        final int batchSize = 5; // Set your batch size here
        int count = 0;
        int aux = 0;

        // Get the total number of '?' in the query
        int totalQueryParameters = Utils.countCharOccurrences(parameterizedQuery, '?');
        final int auxTotalQueryParameters = totalQueryParameters;

        final PreparedStatement preparedStatement = connection.prepareStatement(parameterizedQuery);

        // Auto Commit must be set to false
        connection.setAutoCommit(false);

        for(int i = 0; i < parameters.size(); i++)
        {
            Object obj = parameters.get(i);

            aux++;
            preparedStatement.setObject(aux, obj);

            if(totalQueryParameters == i + 1) { // Because the ArrayList starts from zero.
                // First query "parsed" - > Add to batch
                preparedStatement.addBatch();
                // One query has been added to the batch. Re-adapt the cycle.
                totalQueryParameters = totalQueryParameters + auxTotalQueryParameters;
                aux = 0;
            }

            if(++count % batchSize == 0) {
                preparedStatement.executeBatch();
            }
        }

        preparedStatement.executeBatch(); // insert remaining queries
        preparedStatement.close();
        connection.setAutoCommit(true); // Make it back to default.
    } catch (SQLException ex) {
        // Do the rollback
        doRollback(connection);

        try {
            // Make it back to default.
            connection.setAutoCommit(true);
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }

        // Dont forget to close the preparedStatement and the connection
        // if you don't need the connection open any more.

        ex.printStackTrace();
    }
}


private void doRollback(Connection c) {
    try {
        c.rollback();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}