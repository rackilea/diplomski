public class TestParent {
    protected String parentAttribute;

    public String getParentAttribute() {
        return parentAttribute;
    }
}
public class TestChild  extends TestParent {
    private String childAttribute;

    public String getChildAttribute() {
        return childAttribute;
    }
}