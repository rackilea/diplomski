@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
@IntegrationTest
@Sql({"classpath:rollback.sql", "classpath:create-tables.sql"})
@Transactional
public abstract class IntegrationTest {
}

public class FooTest extends IntegrationTest {

}

public class BarTest extends IntegrationTest {

}