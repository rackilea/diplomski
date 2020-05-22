public class Flooble {
    public int x;
    public int y;

    public Flooble() {
       x = 5;
       y = 1;
    }
}

public class SomeOtherClass {
    public void doWork() {
    while (true) { 
        // do some stuff...
        // use the Flooble, but only if it is ready
        if (floobleLoader.theFlooble != null) 
            doSomething(floobleLoader.theFlooble);
    }

    public void doSomething(Flooble flooble) {
        System.out.println(flooble.x / flooble.y);
    }
}