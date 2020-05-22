@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class)
@EnableWebMvc
@AutoConfigureMockMvc
public class RestControllerMockTest {
@Autowired
HomeRestController homeRestController;

@Before
public void setUp(){
    MockitoAnnotations.initMocks(this);
}

}