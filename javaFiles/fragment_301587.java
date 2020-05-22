@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringTest {

    @Configuration
    @EnableCaching
    static class SpringConfig{
        @Bean
        public CustomerService customerService(){
            return new CustomerServiceImpl(customerRepository());
        }
        @Bean
        public CustomerRepository customerRepository(){
            return Mockito.mock(CustomerRepository.class);
        }
    }

    @Autowired
    CustomerService customerService; // this will contain a proper managed cache

    @Autowired
    CustomerRepository customerRepository; // this is a mockito mock you can fine-tune
}