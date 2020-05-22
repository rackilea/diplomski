package pack.test;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AppTester {
    private static String CONFIGURATION_FILE = "sqlmap-config.xml";

    public static void main(String[] args) throws Exception {
        Reader reader = null;
        SqlSession session = null;
        try {

            reader = Resources.getResourceAsReader(CONFIGURATION_FILE);
            session = new SqlSessionFactoryBuilder().build(reader).openSession();
            UserService userService = session.getMapper(UserService.class);

            // three users retreived from index
            for (int i = 1; i <= 3; i++) {
                User user = userService.getUser(i);
                System.out.println("Retreived user: " + user.getName() + " " + user.getLogin());

                // must mimic the internal statement key for the mapper and method you are calling
                MappedStatement ms = session.getConfiguration().getMappedStatement(UserService.class.getName() + ".getUser");
                BoundSql boundSql = ms.getBoundSql(i); // parameter for the SQL statement
                System.out.println("SQL used: " + boundSql.getSql());
                System.out.println();
            }

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (session != null) {
                session.close();
            }
        }
    }
}