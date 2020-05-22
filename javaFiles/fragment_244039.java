for (int i=0;i<10000;i++) {
        preparedStatement.setString(1, path);
        preparedStatement.setString(2, word);
        preparedStatement.addBatch();
        if ((i + 1) % 1000 == 0) {
            preparedStatement.executeBatch();
            System.out.print("Add Thousand");
        }
    }