while ((nextLine = reader.readNext()) != null) {
    // ...
    preparedStatement.setString(1, nextLine[0]);
    preparedStatement.setString(2, nextLine[1]);
    preparedStatement.setString(3, nextLine[2]);
    preparedStatement.setString(4, nextLine[3]);
    preparedStatement.setString(5, nextLine[4]);
    preparedStatement.setString(6, nextLine[5]);
    preparedStatement.addBatch();
}

preparedStatement.executeBatch();