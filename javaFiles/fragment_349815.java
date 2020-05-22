public class AddressTest {

    @Mock
    private UserDAO userDAO;

    @Mock
    private AddressDAO addressDAO;

    @InjectMocks
    private AddressService addressServie;

    @BeforeMethod
    public void initMock() {
        addressServie = new AddressServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test(dataProvider = "getUser", dataProviderClass = UserDP.class)
    public void shouldThrowExceptionAddressNotFound(int userId, User user) {
        when(userDAO.findOne(userId)).thenReturn(user);
        try {
            addressServie.findAllAddress(userId);
        } catch (BadRequestException badRequestException) {
            assertEquals(badRequestException.getErrorCode(), 102);
        }
    }
}