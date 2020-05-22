@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, 
                properties = { "my.property.enabled = true" })
public class MyServiceTest {

    @Autowired
    private MyService myService;

}