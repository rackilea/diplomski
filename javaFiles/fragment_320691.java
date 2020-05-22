public class MyServiceImplTest 
{
    private MyDataService myDataService;
    private NyService myService;

    @Mock
    private MyRepository myRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // this is needed for inititalizytion of mocks, if you use @Mock 
        myDataService = new MyDataServiceImpl(myRepository);
        myService = new MyServiceImpl(myDataService);
    }

    @Test
    public void getById_ValidId() {

        doReturn(someMockData).when(myRepository).findOne("1");
        MyObject myObject = myService.getById("1");

        //Whatever asserts need to be done on the object myObject 
    }
}