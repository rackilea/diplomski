class ASingletonClass(){
  @Autowired MyRowMapper myRowMapper;

  public MyRowMapper myAweSomeMethod(){
    return jdbcTemplate.query(SQL, new Object[] {}, myRowMapper)
  }
}