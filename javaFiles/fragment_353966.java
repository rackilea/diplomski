try (Connection conn = DriverManager.getConnection(url, userName, password);
     PreparedStatement stmt = conn.prepareStatement(sql)) {
    int rowCount = 0;
    for (String[] row : result) {
        for (int i = 0; i < 5; i++) // hardcoded 5 since SQL has 5 markers
            stmt.setString(i + 1, row[i]);
        stmt.addBatch();
        if (++rowCount % 1000 == 0)
            stmt.executeBatch();
    }
    if (rowCount % 1000 != 0)
        stmt.executeBatch(); // execute last batch
}