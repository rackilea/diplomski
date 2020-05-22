package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        new Application().doSomething(11);
        new Application().doSomething(-22);
        new Application().doSomething(333);
    }

    public void doSomething(int number) {
        System.out.println("Doing something with number " + number);
    }
}