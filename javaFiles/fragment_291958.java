public class UserBindingInitializer implements WebBindingInitializer {

    private OccupationRepository occupationRepository;
    private CountryRepository countryRepository;

    // getter's and setter's (retrieved by Dependency Injection supported by Spring)

    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomPropertyEditor(Occupation.class, new PropertyEditorSupport() {

            public void setAsText(String occupationId) {
                // StringUtils belongs to jakarta-commons lang 
                if(StringUtils.isBlank(occupationId)) {
                    setValue(null);

                    return;
                }

                setValue(occupationRepository.getById(Integer.valueOf(occupationId)));
            }

            public String getAsText() {
                if(getValue() == null)
                    return;

                return String.valueOf(((Occupation) getValue()).getId());
            }
        });
    }

}