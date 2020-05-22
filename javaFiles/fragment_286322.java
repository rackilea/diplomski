@Named(value = "personalInfoController")
@SessionScoped
public class PersonalInforController {

    @EJB
    PersonalInfoFacade ejbFacade;
    PersonalInfo personalInfo;
    String defaultPage = "index";

    @PostConstruct
    public void init() {
        personalInfo = new PersonalInfo();
    }

    public String create() {
    try {
        ejbFacade.create(personalInfo);
        return "prepareCreate";
    } catch (Exception e) {
        return "success";
    }
}