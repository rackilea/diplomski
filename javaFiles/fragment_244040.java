for (int i=0;i<words.length;i++) {
        preparedStatement.setString(1, path);
        preparedStatement.setString(2, words[i]);
        preparedStatement.addBatch();
        if ((i + 1) % 1000 == 0) {
            preparedStatement.executeBatch();
            System.out.print("Add Thousand");
        }
    }
    if (words.length % 1000 > 0) {
        preparedStatement.executeBatch();
        System.out.print("Add Remaining");
    }