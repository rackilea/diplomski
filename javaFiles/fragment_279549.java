@Component
public class BaseController {

   @Autowired
   private CommonDataService commonDataService;

   protected ModelAndView model; 

    @Postconstruct
    public void initCommonData(){
       this.model = new ModelAndView();
       this.model.addObject("headerData",commonDataService.getHeaderData());
       this.model.addObject("footerData",commonDataService.getFooterData());
    }
 }