LocalDate currentDate = LocalDate.now();
DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
public void insert(String code, String description) {
  sql = "INSERT INTO my_table (" +
                "code, " +
                "description, " +
                "created_date)" +
                "VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                new Object[]{
                        code,
                        description,
                        currentDate.format(df)
                }
        );
}