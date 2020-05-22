@Mock
FingerPrintHelper fingerPrintHelper;

@Before
public void setUp() {
    MockitoAnnotations.initMocks(this);
    loginActivity = loginActivityRule.getActivity();
    loginActivity.fingerPrintHelper = fingerPrintHelper;
    // ...
}