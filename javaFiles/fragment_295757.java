@Controller
public class GDataController {

    @Autowired
    GDataJdbcRepository repository;

    @GetMapping("/gdata")
    public String gDataForm(Model model) {
        return "gData";
    }

    @PostMapping("/gdata")
    public RedirectView gDataSubmit(@ModelAttribute GData gData) {
        String returnString = repository.insert(gData);
        return new RedirectView("/sucess?returnString=" + returnString, true);
    }

    @GetMapping("/success")
    public String getResultPage(@RequestParam("returnString")String returnString){
        return "result";
    }
}