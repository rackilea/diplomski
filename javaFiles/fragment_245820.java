@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = YourApplication.class)
public class InternationalizationTests() {

  @Autowired
  ConnectionProperties connectionProperties;

  @Test
  public void testCorrectTranslationLoaded() {
    Assert.assertEquals("english-username", connectionProperties.getUsername());
  }    

}