for (int i=0;i<1000;i++) {
        preparedStatement.setString(1, path);
        preparedStatement.setString(2, word);
        preparedStatement.addBatch();
    }
    preparedStatement.executeBatch();
    System.out.print("Add Thousand");