@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class SomeTest {
    @ClassRule
    public final static TemporaryFolder tempFolder = new TemporaryFolder();

    @Autowired
    private TestBean testBean;

    @Configuration
    static class Config {
        @Bean
        public TestBean testBean() {
            try {
                return new TestBean(tempFolder.newFolder());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
    ...
}