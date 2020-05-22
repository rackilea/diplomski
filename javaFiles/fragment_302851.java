@RunWith(SpringRunner.class)
@SpringBootTest
public class So47793485ApplicationTests {

    @Autowired
    Foo foo;

    @Test
//  @Transactional
    public void contextLoads() {
        foo.foo();
    }

}