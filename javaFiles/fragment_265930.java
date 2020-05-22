@SessionAttributes("thing") // the name of your domain object in the model
public class ThingController {

    public void setDisallowedFields(WebDataBinder binder) {
        binder.setDisallowedFields("id", "someOtherUneditableField");
    }

    // request handling methods go here as before
}