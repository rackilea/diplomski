import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class HelloWorldRepositoryImpl implements HelloWorldRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String callHelloWorld() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_TEST") //package name
                .withFunctionName("HELLO_WORLD");
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("param", "value"));
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(String.class, paramMap));
    }

}