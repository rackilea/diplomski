public class MyValidator extends AbstractDeclarativeValidator {

    public static final String INVALID_NAME = "invalidName";

    @Override
    protected List<EPackage> getEPackages() {
        return Collections.singletonList(MyDslPackage.eINSTANCE);
    }

    @Check
    public void checkGreeting(Greeting g) {
        if (!Character.isUpperCase(g.getName().charAt(0))) {
            warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME, INVALID_NAME);
        }
    }

}