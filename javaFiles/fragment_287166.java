@Controller
public class CoinViewController {

    @Autowired
    private CountryEditor countryEditor;

    @InitBinder
    protected void initBinder(final WebDataBinder binder, final Locale locale) {
        binder.registerCustomEditor(Country.class, countryEditor);
    }

    ......
}