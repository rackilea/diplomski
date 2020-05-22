@FunctionalInterface
public interface MyFunctionalInterface {
    String getString();
}

MyFunctionalInterface function = () -> {
    Date d = new Date();
    return d.toString() + " " + person.name + " used fnc str";
};

public SampleClass(MyFunctionalInterface function) {
    String tmp = "The person info: %s";
    this.result = String.format(tmp, function.getString());
}