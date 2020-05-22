@Captor
ArgumentCaptor<LinkedList<String>> captor;

@Before
public void init() {
   // initialize fields annotated with Mockito annotations
   MockitoAnnotations.initMocks(this);  
}