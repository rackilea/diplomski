@TestPropertySource(locations="classpath:SettingsTest.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfigurationNew.class)
public class SettingsTest {

    @Autowired
    TestSettings settings;

    @Test
    public void testConfig(){
        Assert.assertEquals("TEST_PROPERTY", settings.getProperty());
    }
}