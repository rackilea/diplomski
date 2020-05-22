@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= ConcertConfig.class)
public class OnePerformanceTest {
    @Autowired
    private Performance performance;

    @Test
    public void perform() throws Exception {
        Encoreable encoreable = (Encoreable)(performance);
        encoreable.performEncore();
    }
}