while (rs.next()) {
    String title = rs.getString("Title");
    String season = rs.getString("Season");
    String episode = rs.getString("Episode");

    String[] columns = { "Title", "S", "E" };
    String[][] data = { { title, season, episode } };

    jt = new JTable(data, columns); // *** you're making many JTables here!! ***
}