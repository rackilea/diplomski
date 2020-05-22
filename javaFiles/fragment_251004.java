// HelloWorld.java
public class HelloWorld {
    public static void say(String message) {
        System.out.println(message);
    }

    public static void sayToPerson(String message, String name) {
        System.out.println(name + ", " + message);
    }
}


// PoliteHelloWorld.java
public aspect PoliteHelloWorld {
    pointcut callSayMessage() : call(public static void HelloWorld.say*(..));
    before() : callSayMessage() {
        if( is_aspectj_turned_on_this_run() ) {
            System.out.println("Good day!");
        }
    }
    after() : callSayMessage() {
        if( is_aspectj_turned_on_this_run() ) {
            System.out.println("Thank you!");
        }
    }
}