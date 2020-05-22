@ManagedBean
@RequestScoped
public class AddressController {

    @EJB
    private AddressBO addressBO;

    @PostConstruct
    public void init() {
        stateList = enderecoBO.loadStateListSelectItem();
    }

    public void changeState(AjaxBehaviorEvent event) {
        String state = (String) ((UIInput) event.getComponent()).getValue();
        cityList = addressBO.loadCityList(state);
    }

    // ... 
}