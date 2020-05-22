@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:aConfig.xml")
@TestExecutionListeners(listeners = ShutdownExecutionListener.class)
public class TestService
{
     @Resource
     EmbeddedMysqlDatabase mysqlDB;

     ...
}