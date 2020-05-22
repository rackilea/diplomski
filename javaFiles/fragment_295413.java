package de.scrum_master.app;

public class NewAccountSummary implements AccountSummary {
    @Override
    public void doSomething() {
        System.out.println("I am " + this);
    }
}