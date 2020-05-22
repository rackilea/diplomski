@Configuration
    public class DbConfig {

    @Bean
    public DataSource dataSource() {

        //Create the DataSource with integration-DB properties

        return dataSource;
    }
}

    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest
    @ContextConfiguration(classes=DbConfig.class)
    public class EntityDaoTest {

    }