package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            PoolableBusinessLogic businessLogic = new PoolableBusinessLogic();
            businessLogic.foo();
            businessLogic.bar();
            System.out.println();
        }
    }
}