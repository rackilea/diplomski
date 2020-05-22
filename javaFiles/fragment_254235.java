import java.util.ArrayList;
import java.util.List;

public class DesignPatterns {

    public static void main(String[] args) {
        List<ConditionChecker> checkers = new ArrayList<>();
        checkers.add(person -> person != null);
        checkers.add(person -> person.getName() != null);
        checkers.add(person -> person.getName().length() > 0);
        checkers.add(new MacroViewConditionChecker(new MacroView()));
        checkers.add(new RestApiConditionChecker(new RestApi()));

        Person person = new Person();
        person.setName("Name");

        for (ConditionChecker checker : checkers) {
            System.out.println(checker.isInCondition(person));
        }
    }
}

interface ConditionChecker {

    boolean isInCondition(Person person);
}

class MacroViewConditionChecker implements ConditionChecker {

    private final MacroView macroView;

    public MacroViewConditionChecker(MacroView macroView) {
        this.macroView = macroView;
    }

    @Override
    public boolean isInCondition(Person person) {
        return macroView != null;
    }
}

class MacroView {
}

class RestApiConditionChecker implements ConditionChecker {

    private final RestApi restApi;

    public RestApiConditionChecker(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public boolean isInCondition(Person person) {
        return restApi.checkName(person.getName());
    }
}

class RestApi {

    public boolean checkName(String name) {
        System.out.println("Validate name ...");
        System.out.println(name + " is valid");

        return true;
    }
}

class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}