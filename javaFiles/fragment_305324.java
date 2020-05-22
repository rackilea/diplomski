@Controller
public class YourController {

    private OptionService optionServiceImpl;

    @RequestMapping("/")
    public String getIndex(){
        Option option = getOptionServiceImpl().findOption(true);
        System.out.println(option.getName());
        option = getOptionServiceImpl().findOption(false);
        System.out.println(option.getName());

        return "Hello World";
    }

    public OptionService getOptionServiceImpl() {
        return optionServiceImpl;
    }

    @Autowired
    public void setOptionServiceImpl(OptionService optionServiceImpl) {
        this.optionServiceImpl = optionServiceImpl;
    }
}