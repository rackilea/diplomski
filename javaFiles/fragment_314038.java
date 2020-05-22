import static org.mockito.Mockito.*;

@RunWith(MockitoJunitRunner.class)
public class UnitTest {
    @Mock private Context context;

    @Before
    public void init() throws Exception {
        when(context.doStuff()).thenReturn("stuff");
        unit = new Unit("dm","length", (float) 0.1, context);
    }
    ...