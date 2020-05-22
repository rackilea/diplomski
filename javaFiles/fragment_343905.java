protected final void closeDbResources(Connection conn, List<Statement> stmt) {
    for (Statement s : stmt) {
        if (s != null) {
            log.debug("[SQL QUERY]: " + s);
            try {
                s.close();
            } catch (SQLException e) {}
        }           
    }
}