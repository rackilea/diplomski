@Controller
public class RuleController {
    @Autowired
    private RuleRepository ruleRepository;

    // Approach 1: Use Request Parameters - enforce inputs
    @PostMapping("/rule/:id")
    public Rule postWithRequestParams(@PathParam("id") Long id, 
                    @RequestParam("type") String type, 
                    @RequestParam("hint") String hint, 
                    @RequestParam("languageField1") String languageField1) {
        Rule inputRule = new Rule(id, type, hint, new Language(languageField1));

        Rule responseRule = ruleRepository.save(inputRule);
        return responseRule; // I would imagine you would want to set up a model for the response itself
    }



    // Approach 2: Use RequestBody - serialize Rule from the request
    @PostMapping("/rule/:id")
    public Rule postWithRequestParams(@PathParam("id") Long id, @RequestBody Rule inputRule) {
        Rule responseRule = ruleRepository.save(inputRule);
        return responseRule;
    }