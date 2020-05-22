@Controller
@Template(id= HomePageTemplate.ID, title = "Home Page")
public class HomePageTemplate {

    @Autowired
    private TemplatingFunctions cmsfn;

    public String render(Model model, Node node) {
        model.addAttribute("meta", new MetaModel(node, cmsfn));
    }
}