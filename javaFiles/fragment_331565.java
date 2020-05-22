@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepoTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    //NOTE: No @Transactional
    public void testSaveFails() throws Exception {
        customerRepository.save(new Customer("John", "Smith"));
        Customer john = customerRepository.findCustomerByName("John");
        john.setSurname("Barton");
        customerRepository.flush();
        customerRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    public void testSaveWorks() throws Exception {
        customerRepository.save(new Customer("John", "Smith"));
        Customer john = customerRepository.findCustomerByName("John");
        john.setSurname("Barton");
        //customerRepository.flush(); Flush is not necessary
        customerRepository.findAll().forEach(System.out::println);
    }

}