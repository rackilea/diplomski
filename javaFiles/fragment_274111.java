public enum MyEnum {
A;

public final String id;
public final String source;
public final String target;

MyEnum() {
    this.id = BUNDLE.getString("A.id");
    this.source = BUNDLE.getString("A.source");
    this.target = BUNDLE.getString("A.target");
}

private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(...);
}