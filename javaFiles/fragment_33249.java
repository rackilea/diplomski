@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConsumerConfig.class, ConfigsService.class})
@TestPropertySource(locations = "classpath:consumer.properties")
public class ConfigsServiceTest {

  @Autowired
  private ConfigsService configsService;

  @Test
  public void someTest() {
    Assert.assertNotNull(configService.getConfig().getHostname());
  }
}