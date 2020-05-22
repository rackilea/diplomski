@XStreamAlias("root")
public class Type {
    private Info info;

    @XStreamImplicit(itemFieldName = "type")
    private List types = new ArrayList();
}

private class Info {
    // ... define the attributes for the info element here.
}