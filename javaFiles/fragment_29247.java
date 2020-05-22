class YourMapperTest {

    @Test
    void testMapRow() throws Exception {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getString("yourStringColumn")).thenReturn("Hello World");
        when(resultSet.getLong("yourLongColumn")).thenReturn(1067L);

        YourDTO dto = new YourRowMapper().mapRow(resultSet, 0);
        assertEquals("some expected string", dto.toString());
    }
}