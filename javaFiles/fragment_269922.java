public class Foo  {
    public Configuration configure() {
        return new Configuration().withPropertyA().withPropertyB();
    }
}

class Configuration {
    Set<StuffStrategy> strategies = new HashSet<StuffStrategy>();

    public Configuration withPropertyA() {
        strategies.add(new PropertyAStrategy());
        return this;
    }

    public Configuration withPropertyB() {
        strategies.add(new PropertyBStrategy());
        return this;
    }

    public void executeStrategies() {
        for (StuffStrategy strategy : strategies) {
            strategy.doStuff();
        }
    }
}

interface StuffStrategy {
    public void doStuff();
}
class PropertyAStrategy implements StuffStrategy {
    @Override
    public void doStuff() {
    }
}

class PropertyBStrategy implements StuffStrategy {
    @Override
    public void doStuff() {
    }
}

class Client {
    public void someMethod(Configuration config) {
        config.executeStrategies();
    }
}