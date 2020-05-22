import com.me.data.userservice.models.UserDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by me on 5/27/17.
 */
public class UserDetailsMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        UserDetails userDetails = new UserDetails();
               userDetails.setAccount_number(resultSet.getString("account_number"));
        userDetails.setCompany_name(resultSet.getString("company_name"));
        ...
        return userDetails;
    }
}