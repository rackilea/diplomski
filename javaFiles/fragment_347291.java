@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private School school;

    @Autowired
    private University university;

    @Test
    public void testPersonDependencies() {
        assertThat(school.personName()).isEqualTo("Jacobs");
        assertThat(university.personName()).isEqualTo("Adam");
    }
}