@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@TestPropertySource(properties = "debug=true")
public class YourTests {
    // …
}