@RunWith(SpringRunner.class)
 @SpringBootTest(classes = Main.class)

 @WebAppConfiguration
 public class GameProjectBackEndApplicationTests {

     private MockMvc mvc;

     @Autowired
     private WebApplicationContext webApplicationContext;

     @MockBean
     private PlayerRepository playerRepository;

     @Before
     public void setUp() {
         mvc = 
         MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

         // Mock calls to PlayerRepository
         // Mockito.when(playerRepository.getEntries(1)).thenReturn(myList);
     }

     @Test
     public void myTest() {
      ....
     }

}