@RunWith(MockitoJUnitRunner.class)
public class DemoTest {
    @Spy
    private SomeService service = new RealServiceImpl();

    @InjectMocks
    private Demo demo;

    /* ... */
}