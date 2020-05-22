List<String> stats = Arrays.asList("OPEN", "CLOSED", "WOUNDED", "IN PROGRESS");

String markers = StringUtils.repeat(",?", stats.size()).substring(1);
String sql = "SELECT * FROM MyTable WHERE Stat IN (" + markers + ")";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    for (int i = 0; i < stats.size(); i++)
        stmt.setString(i + 1, stats.get(i));
    try (ResultSet rs = stmt.executeQuery()) {
        // use rs here
    }
}