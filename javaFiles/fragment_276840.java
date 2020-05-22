public interface Advised {
    String buildGreeting(String name);
}

public class AdvisedImpl implements Advised {
    String buildGreeting(String name) {
        return "ADVISED";
    }
}

public class Greeter {
    public String greet(String name) {
        return "Hello, " + name + ".";
    }
}

...

public aspect GreeterAspect {
    @Inject
    private Greeter Advised.greeter; // adding the member to the interface / class. No need for getters / setters

    private pointcut pc() : execution(* x.y.z.Advised.buildGreeting(String));

    String around(Advised adv, String name) : pc() && target(adv) && args(name) {
        log.debug("Aspect is about to say something...");
        String result = proceed(adv, name) + " - " + adv.greeter.greet(name);
        log.debug("Aspect said: '" + result + "'");
        return result;
    }
}