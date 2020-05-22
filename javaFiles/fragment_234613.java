@Repository
public class MyEntityRepository {

    private final JdbcTemplate jdbcTemplate;

    public MyEntityRepository(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    public void save(MyEntity e) {
        jdbcTemplate.update("INSERT INTO TABLE (PARAM_A, PARAM_B) VALUES(?,?)",
                new Object[]{e.getParamA(), e.getParamB()});
    }

}