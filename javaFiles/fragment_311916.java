package de.scrum_master.app;

public class Application {
    @DynamicValue(lookupName = "foobar")
    public String greet;
    public String anotherMember;

    public static void main(String[] args) {
        Application application = new Application();
        application.greet = "world";
        application.anotherMember = "Another member";
        application.sayHello();
    }

    private void sayHello() {
        System.out.println(anotherMember);
        System.out.println("Hello " + greet);
    }
}