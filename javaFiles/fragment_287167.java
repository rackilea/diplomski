@Component
public class CountryEditor extends PropertyEditorSupport {

    @Autowired
    private CountryService countryService;

    @Override
    public void setAsText(final String text) throws IllegalArgumentException {
        try{ 
            final Country country = countryService.findById(Long.parseLong(text));
            setValue(cliente);
        }catch(Exception e){
            setValue(country);
            // or handle your exception
        }
    }
}