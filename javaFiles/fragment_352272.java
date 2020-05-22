@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext-test.xml" })
@TestExecutionListeners(listeners = { LiquibaseTestExecutionListener.class,
    DependencyInjectionTestExecutionListener.class })
@LiquibaseChangeSet(changeSetLocations = { "liquibase/v001/createTables.xml" })
public class DeviceDAOTest {
    ...