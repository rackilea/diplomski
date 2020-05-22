@RunWith(SpringRunner.class)
@Ignore
@SpringBootTest(properties="springBootApp.workOffline=true")
public class BaseTest {
    @Before
    public void beforeTest() { /* setup */ }

    @After
    public void afterTest() { /* teardown */ }
}