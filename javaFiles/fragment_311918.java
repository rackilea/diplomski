package de.scrum_master.app;

public class Application {
    @DynamicValue(lookupName = "foobar")
    public String greet;
    public String anotherMember;
    @DynamicValue(lookupName = "primitive")
    public int primitiveNumber;
    @DynamicValue(lookupName = "boxed")
    public Integer boxedNumber;

    public static void main(String[] args) {
        Application application = new Application();
        application.greet = "world";
        application.anotherMember = "Another member";
        application.primitiveNumber = 11;
        application.boxedNumber = 22;
        application.sayHello();
    }

    private void sayHello() {
        System.out.println(anotherMember);
        System.out.println("Hello " + greet);
        System.out.println(primitiveNumber);
        System.out.println(boxedNumber);
    }
}