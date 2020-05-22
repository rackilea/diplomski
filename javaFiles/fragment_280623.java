public long getCount() {
    String sql = "SELECT COUNT(DISTINCT UPPER(l.city))"
            + " FROM location_table_name l WHERE l.active = true";

    return ((BigInteger) em.createNativeQuery(sql)
            .getSingleResult())
            .longValue();
}