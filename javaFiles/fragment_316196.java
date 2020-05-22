@Before
public void setUp() {
    loginActivity = loginActivityRule.getActivity();
    loginActivity.fingerPrintHelper = Mockito.mock(FingerPrintHelper.class);
    // ...
}