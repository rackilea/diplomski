@RunWith(MockitoJUnitRunner.class)
public class RequestThreadTest {

    private static final Path FILE = Paths.get("someDir", "sample");

    @Mock
    MyDataWebServiceInterface service;

    @InjectMocks
    MainThreads.RequestThread reqThread = new MainThreads.RequestThread("sample");

    @Before
    public void setup() throws IOException, InterruptedException {
        if (Files.exists(FILE)) {
            Files.delete(FILE);
            while (Files.exists(FILE)) {
                Thread.sleep(50);
            }
        }
    }

    @Test
    public void shouldWriteFile() throws InterruptedException {
        Mockito.when(service.requestData()).thenReturn(Arrays.asList("one", "two"));
        reqThread.start();
        while (!Files.exists(FILE)) {
            Thread.sleep(50);
        }
        // HERE run assertions about file content
    }
}