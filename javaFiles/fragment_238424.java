@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class PropertyTests {
    @Value("${elastic.index}")
    String index;

    @Configuration
    @Import({PropertyTestConfiguration.class})
    static class ContextConfiguration {
    }
}