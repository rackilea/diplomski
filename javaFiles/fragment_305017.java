@Testcontainers
@SpringBootTest
public class BaseIntTest {

    @Container
    private static final PostgreSQLContainer<?> container = CustomPostgreSQLContainer.getInstance();