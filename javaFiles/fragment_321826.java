@ManagedBean
@ViewScoped
public class TestBean {

    private String testString;
    private String savedTestString;

    public void testAction() {
        savedTestString = testString;
        testString = null;
    }

    // ...
}