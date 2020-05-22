@RunWith(SpringRunner.class)
public Class1Test {

    @InjectMocks
    @Autwired
    private Class1 class1;

    @Mock
    Class2 class2;

    @BeforeMethod
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public Object testClass1Method {
        when(class2.class2Method(anyString()).thenReturn(expectedReturn);
        //Now test whatever you need with mocked class2.class2Method 

    }
}