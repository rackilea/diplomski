public class MySimpleClass {

    private List<String> mDependency;

    @Inject
    public MySimpleClass (List<String> dependency) {
        mDependency = dependency;
    }
}