@Component
public class UserDetailsRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public UserDetails findByUserIdAndDomain(@Param("p_in_user_id") String userId, @Param("p_in_region") String region) {

        String sql = "select * from TABLE(user_pkg.get_user_details(:p_in_user_id,:p_in_region))";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource("p_in_user_id", userId)
                .addValue("p_in_region", region);
        UserDetails result = (UserDetails)jdbcTemplate.queryForObject(
                sql, namedParameters, new UserDetailsMapper());

        return result;

    }
}