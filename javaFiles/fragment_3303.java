long now = System.currentTimeMillis();

while (rs.next()) {
    Timestamp ts = rs.getTimestamp("HIGH_VALUE");
    long diff = ts.getTime() - now;
    ... use diff ...
}