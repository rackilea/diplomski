@Test
public void testTask() throws InterruptedException {
    //arrange
    LocalDate tdate = LocalDate.parse("2014-02-23");
    AbstractTaskDao abstratTaskDao = Mockito.mock(AbstractTaskDao.class, Mockito.CALLS_REAL_METHODS);
    NamedParameterJdbcTemplate jdbcTemplate = Mockito.mock(NamedParameterJdbcTemplate.class);
    JdbcOperations operations =  Mockito.mock(JdbcOperations.class);

    when(jdbcTemplate.getJdbcOperations()).thenReturn(operations);
    when(abstratTaskDao.getQuery()).thenReturn("select * from dual");

    //use reflection to inject autowired field.
    org.springframework.test.util.ReflectionTestUtils.setField(abstratTaskDao, "jdbcTemplate", jdbcTemplate);

    System.out.println("\n\t sql-"+abstratTaskDao.getQuery());

    //act
    abstratTaskDao.addTask(myqueue, tdate);

    //assert
    verify(jdbcTemplate).query(...);

}