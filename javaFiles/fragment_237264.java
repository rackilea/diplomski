@RunWith(SpringRunner.class)
@Import({
    MockIntegrationConfiguration.class,
    RealConfiguration.class,
})
@WebMvcTest(RestController.class)
public class RestControllerTest {