@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.jmx.enabled=true")
@DirtiesContext
public class SampleJmxTests {

    @Autowired
    private MBeanServer mBeanServer;

    @Test
    public void exampleTest() {
        // ...
    }

}