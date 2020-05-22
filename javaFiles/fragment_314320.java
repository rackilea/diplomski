@FunctionalInterface
public interface MyFunctionalInterface {
    String getString(Person p);
}

MyFunctionalInterface function = p -> {
    Date d = new Date();
    return d.toString() + " " + p.name + " used fnc str";
};

public SampleClass(MyFunctionalInterface function, Person person) {
    String tmp = "The person info: %s";
    this.result = String.format(tmp, function.getString(person));
}