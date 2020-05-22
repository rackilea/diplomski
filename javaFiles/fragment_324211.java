@RunWith(MockitoJUnitRunner.class)
public class HelloUiTest {
    private HelloUi ui;

    @Mock
    private Page page;

    @Mock
    private VaadinRequest req;

    @Before
    public void setup() throws Exception {
        initUi();
        mockPage();
    }

    private void initUi() {
        ui = new HelloUi();
        ui.init(req);
        CurrentInstance.setInheritable(UI.class, ui);
    }

    private void mockPage() throws NoSuchFieldException, IllegalAccessException {
        Field pageField = UI.class.getDeclaredField("page");
        pageField.setAccessible(true);
        pageField.set(ui, page);
    }

    @Test
    public void testNotification() {
        ui.getButton().click();

        verify(page).getLocation();
    }
}