String findEntryCount = "SELECT count(*) FROM HighScore WHERE " +
        "username='testAddEntry'";
try (ResultSet rs = st.executeQuery(findEntryNow)) {
    assertTrue(rs.next()); // even absence of entries will produce a row
    assertEquals(0, rs.getInt(1));
}