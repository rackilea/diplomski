@WithMockUser(username = "usertest", password = "password", roles = "USER")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FooServiceTest {

    @Autowired
    private FooService service;

    @Test
    public void someTest() {    
        service.findFoo(1L);
    }

}