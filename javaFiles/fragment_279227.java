@RunWith(MockitoJUnitRunner.class)
public class LoginActivityTest {

    @Mock User user;
    @Mock LoginView loginView;
    @Mock MyValidator validator;

    LoginPresenter presenter;

    @Before
    public void beforeTest() {
        presenter = new LoginPresenterImpl(loginView, validator);
    }

...