public class HelloGreeting extends AbstractGreeting {
    public HelloGreeting(String name) { super(name);}
    @Override protected String getGreeting() { return "Hello"; }
}

public class AlohaGreeting extends AbstractGreeting {
    public AlohaGreeting (String name) { super(name);}
    @Override protected String getGreeting() { return "Aloha"; }
}