@RunWith(PowerMockRunner.class)
@PrepareForTest(PaymentServiceImpl.class)
public class PaymentServiceImplTest {

    private IPaymentService paymentService;

    @Before
    public void init() {
        paymentService = PowerMockito.spy(Whitebox.newInstance
                (PaymentServiceImpl.class));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {
        ...
        PowerMockito.doReturn(mockedReturn)
                .when(paymentService,
                      "toMockMethod",
                      arg1, arg2);
    }
}