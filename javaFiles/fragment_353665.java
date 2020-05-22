@RunWith(MockitoJunitRunner.class)
public class RealWorkWindowTest {

  @Mock
  Factory myFactory;

  @Mock
  WorkWindow defaultWindow;

  @Mock
  WorkWindow workWindow;

  RealWorkWindow realWorkWindow;

  @BeforeEach
  void setup() {
    when(myFactory.create(any(LongSupplier.class)))
        .thenReturn(defaultWindow) // First call
        .thenReturn(workWindow);   // Second call
    realWorkWindow = new RealWorkWindow(myFactory, () -> 1000L);
  }

}