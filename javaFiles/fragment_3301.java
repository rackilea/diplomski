@Controller
@RequestMapping("/jira/worklogs")
public class JiraWorkLog {

    private static final Logger logger = Logger.getLogger(JiraWorkLog.class.getName() );

    @RequestMapping(path = "/get", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<JiraWorklogIssue> getWorkLog(@RequestParam(name = "username") String username) {


        String theUrl = "http://my-jira-domain/rest/api/latest/search?jql=assignee="+username+"&fields=worklog";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<JiraWorklogIssue> response = null;
        try {
            HttpHeaders headers = createHttpHeaders();
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
            response = restTemplate.exchange(theUrl, HttpMethod.GET, entity, JiraWorklogIssue.class);
            System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
        }
        catch (Exception eek) {
            System.out.println("** Exception: "+ eek.getMessage());
        }

        return response;

    }

    private HttpHeaders createHttpHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic encoded64 username:password");
        return headers;
    }

}