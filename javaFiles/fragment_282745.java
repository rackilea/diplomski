@RestController
@RequestMapping("/test")
public class IapaController {

    @Autowired
    IapaService iapaService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/v1/the-only-query-on-2nd-datasource")
    public List<String> test2ndDS() {
        String query = "Select * ....";
        List<String> itemList = (List<String>) jdbcTemplate.queryForList(query, String.class);   
        return itemList ;
    }

    @RequestMapping("/v1/primary-ds-is-working-fine")
    public List<IapaTipiAndamenti> test1stDS() {
        return iapaService.test1stDS(); //This is working, here for example I will use a typical jpa findAll
    }

//...other jpa methods for the primary datasource
    }