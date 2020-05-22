@RunWith(SpringRunner.class)
@DataJdbcTest
public class DataJdbcSampleTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    ...
}