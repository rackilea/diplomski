import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

    @RunWith(MockitoJUnitRunner.class)
    public class PaidListTest {

        @Mock
        PaymentService paymentService;

        @Before
          public void setUp() {
             MockitoAnnotations.initMocks(this);
             mapperObj = new ObjectMapper();
             List<PaymentGetServiceDO> response = new ArrayList<PaymentGetServiceDO>();
}
        @Test
        public void getPaidList() {
            List<PaymentGetServiceDO> response = null;
            try {
                response = paymentService.setPaidStatusList();          
                if(response != null && response.size() > 0){
                    for(int i = 0; i < response.size(); i++){
                        assertNotNull(response.get(i).getAgentcode());
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }