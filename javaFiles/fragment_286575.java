public class TestApiController {

private TestFeedService testService; // This is an interface 

@Autowired
public TestApiController(TestFeedService testService ) {
    this.testService = testService;
}

@RequestMapping(path = "/api/process-message", method = RequestMethod.POST)
public ResponseEntity<?> processMessage(@RequestBody TestForm2 testForm) {
  DataBO dataBO = convertBO(testForm);
  testService.sendMessage(dataBO, false);  // here I am getting testService = null and causing exception
  return ResponseEntity.ok().build();
} // Some more code