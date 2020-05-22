@RestController
@RequestMapping("/api/v1")
public class SearchController {

    @Autowired
    private RestClient restClient;

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces="application/json" )
    public ResponseEntity<Object> getSearchQueryResults(@RequestParam(value = "criteria") String criteria) throws IOException {

        // Setup HTTP Headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // Setup query and send and return ResponseEntity...

        Response response = this.restClient.performRequest(...);

    }

    @PreDestroy
    public void cleanup() {
        try {
            logger.info("Closing the ES REST client");
            this.restClient.close();
        } catch (IOException ioe) {
            logger.error("Problem occurred when closing the ES REST client", ioe);
        }
    }

}