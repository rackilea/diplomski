public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
       this.jdbcTemplateObject = new JdbcTemplate(dataSource);
       this.namedJdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
   }

   public List<String> listStudentsNames() {
       String SQL = "select name from Student where id IN (:tags)";

       Integer[] intArray = {1, 2, 3};
       List<Integer> intList = Arrays.asList(intArray);

       MapSqlParameterSource params = new MapSqlParameterSource();
       params.addValue("tags", intList);

       return namedJdbcTemplateObject.queryForList(SQL, params, String.class);

    }