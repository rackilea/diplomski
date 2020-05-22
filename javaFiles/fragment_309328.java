@RequestMapping("VIEW")
@Controller
public class NewsPortlet {

    private NewsService newsService;

    @Autowired
    public NewsPortlet(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view(Model model) {
        model.addAttribute(newsService.getLatests(10));
        return "news";        
    }
}