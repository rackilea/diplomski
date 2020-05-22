import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class DBReader implements ResultSetExtractor {

@Override
public Object extractData(ResultSet rs) throws SQLException,
        DataAccessException {

    Map<String, TestClass> items = new HashMap<String, TestClass>();

    while(rs.next()) {

        TestClass test = items.get(rs.getString("ID"));

        if (test == null) {

            test = new TestClass();
            test.setId(rs.getInt("ID"));
            test.setText(rs.getString("Text"));

        } 

        test.getCountry().add(rs.getString("Country"));
    }

    return items;
}

}