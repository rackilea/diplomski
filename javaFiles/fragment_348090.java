public class TestString {

private String name;

public TestString(String name) {
    super();
    this.name = name;
}

public TestString() {
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public String toString() {
    return "TestString [name=" + name + "]";
}

}