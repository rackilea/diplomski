@Mock
StudentDAO stuDAO;

@InjectMocks
StudentService stuService;

And in setUp() method I have written

MockitoAnnotations.initMocks(this);