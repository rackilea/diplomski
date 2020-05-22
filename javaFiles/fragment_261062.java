import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class ConstructorPropertiesExplore {

    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:h2:mem:test");
        jdbi.installPlugin(new SqlObjectPlugin());

        List<User> users = jdbi.withExtension(UserDao.class, dao -> {
            dao.createTable();
            dao.insertPositional(0, "Alice");
            dao.insertPositional(1, "Bob");
            dao.insertPositional(2, "Clarice");
            dao.insertPositional(3, "David");

            return dao.listUsers();
        });

        assertThat(users).containsExactly(new User(0, "Alice"), new User(1, "Bob"), new User(2, "Clarice"),
                new User(3, "David"));
    }

}