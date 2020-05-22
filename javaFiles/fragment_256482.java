public long getTotal(int feedId) {
    String sql = "select sum(total_amount) as total from event_feed_summary_view where feed_id = :feed_id;";
    SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
    sqlQuery.setParameter("feed_id", feedId);
    SqlRow r = sqlQuery.findUnique();
    if (r != null && r.getLong("total") != null) {
        return r.getLong("total");
    }
    return 0;
}