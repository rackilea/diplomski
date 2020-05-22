private class StatementCache {
    Map<String, PreparedStatement> statementCache = new HashMap<>();
    public BoundStatement getStatement(String cql) {
        PreparedStatement ps = statementCache.get(cql);
        // no statement cached, create one and cache it now.
        if (ps == null) {
            ps = session.prepare(cql);
            statementCache.put(cql, ps);
        }
        return ps.bind();
    }
}