private ResultSet getMockResultSet() throws Exception {
    ResultSet rs = Mockito.mock(ResultSet.class);
    Mockito.when(rs.next()).thenReturn(true).thenReturn(false);
    Mockito.when(rs.getString(1)).thenReturn("Value 1");
    Mockito.when(rs.getString(2)).thenReturn("Value 2");
    return rs;
}

private ResultSet getEmptyMockResultSet() throws Exception {
    ResultSet rs = Mockito.mock(ResultSet.class);
    Mockito.when(rs.next()).thenReturn(false);
    return rs;
}

@Test
public void testDataExists() {
    Item item = new ResultSetExtractor<Item>() {
        @Override
        public Item extractData(final ResultSet rs) throws ... {
            if (rs.next()) {
                Item item = new Item (rs.getString(1), rs.getString(2));
                return item ;
            } else
                return null;
        }
    }.extractDatae(getMockResultSet());
    assertEquals(item.getFirst(), "Value 1");
    assertEquals(item.getSecond(), "Value 2");
}


@Test
public void testNoDataExists() {
    Item item = new ResultSetExtractor<Item>() {
        @Override
        public Item extractData(final ResultSet rs) throws ... {
            if (rs.next()) {
                Item item = new Item (rs.getString(1), rs.getString(2));
                return item ;
            } else
                return null;
        }
    }.extractData(getEmptyMockResultSet());
    assertNull(item);
}