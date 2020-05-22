@RunWith(SpringRunner.class)
@SpringBootTest(classes = SomeApplication.class)
public class SomeControllerTest {

    @Autowired
    private WebApplicationContext context;

    @MockBean(name = "mvcConversionService")
    private WebConversionService webConversionService;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(context);

        SomeEntity someEntity = new SomeEntity();

        when(webConversionService.canConvert(any(TypeDescriptor.class), any(TypeDescriptor.class)))
                .thenReturn(true);

        when(webConversionService.convert(eq("1"), any(TypeDescriptor.class), any(TypeDescriptor.class)))
                .thenReturn(someEntity);
    }
}