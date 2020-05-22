import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class SampleInfo{

    @Autowired(required=true)
    DataSource getDataSource;

    @Autowired(required=true)
    JdbcTemplate getJdbcTemplate;

    public void callInfo() {
        System.out.println(getDataSource);
        System.out.println(getJdbcTemplate);

    }

}