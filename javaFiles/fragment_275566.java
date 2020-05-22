@RestController
public class TestController {
    private final MockData mockData;

    @Autowired
    public TestController(MockData mockData) {
        this.mockData = mockData;
    }

    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public String getCsv() {
        return mockData.getCSV();
    }
}