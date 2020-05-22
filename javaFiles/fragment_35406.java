@Mock
private EsmRegexValidator regexValidator;

@Mock
private EsmFormNotNullValidator notNullValidator;

@Mock
private EsmFormDataTypeValidator dataValidator;

@InjectMocks
private EsmFormValidatorManager validatorManager;

@Spy
private List<IEsmFormValidator> validators = new ArrayList<IEsmFormValidator>();

@Mock
private ColumnDTO columnDTO;

@Before
public void init() {

    MockitoAnnotations.initMocks(this);

    validators.add(notNullValidator);
    validators.add(regexValidator);
    validators.add(dataValidator);

    Mockito.when(columnDTO.getTitle()).thenReturn("Mock title");
    Mockito.when(columnDTO.getName()).thenReturn("Mock name");
}