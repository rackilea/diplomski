public class MyValidator extends AbstractDeclarativeValidator {

    public static final String INVALID_NAME = "invalidName";

    @Override
    protected List<EPackage> getEPackages() {
        return Collections.singletonList(MyDslPackage.eINSTANCE);
    }

    @Check(CheckType.FAST)
    public void checkFast(EObject g) {
        // TODO
    }
    @Check(CheckType.NORMAL)
    public void checkNormal(EObject g) {
        // TODO
    }
    @Check(CheckType.EXPENSIVE)
    public void checkExpensive(EObject g) {
        // TODO
    }

}