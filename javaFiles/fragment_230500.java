public void setUpdateExpectedQuery(String ...expectedQueryStrings)
    throws SQLException {
    final Set<String> capturedQueries = new HashSet<>
       (Arrays.asList(expectedQueryStrings);

    Statement mockStatement = mock(Statement.class);
    when(mockConnection.createStatement()).thenReturn(mockStatement);

    when(mockStatement.executeUpdate(anyString())).then(new Answer<String>() {    
        @Override
        public String answer(InvocationOnMock invocationOnMock) throws Throwable {
            String query = (String) invocationOnMock.getArguments[0];
            if (capturedQueries.contains(query)) {
                return null;
            }
            throw new RuntimeException("Update string is not as expected: " + query);
        }

    });
}