public class FooController {

    private final FormFactory formFactory;

    @Inject
    public FooController(final FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result hello() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String firstname = requestData.get("firstname");
        String lastname = requestData.get("lastname");
        return ok("Hello " + firstname + " " + lastname);
    }
}