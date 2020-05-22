public class MyObject {

    private final OptionalContainerRequestContext optionalContainerRequestContext;

    @Inject
    public MyObject(OptionalContainerRequestContext optionalContainerRequestContext) {
        this.optionalContainerRequestContext = optionalContainerRequestContext;
    }

}