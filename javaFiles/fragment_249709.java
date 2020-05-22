@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestContextConfiguration.class)
public class StoreClientTest {

    @Value("${name}")
    private String name;
    // test cases ..
}