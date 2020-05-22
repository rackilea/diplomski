@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@TestPropertySource(properties = {"mock.random-devices=false", "spring.application.name=BTest", "spring.jmx.default-domain=BTest"})
@ActiveProfiles("test")
public class BTest {
    @Test
    public void bTest() throws Exception {
        Assert.assertEquals("Hello", "Hello");
    }
}