package de.scrum_master.app;

public class LegacyAccountSummary implements AccountSummary {
    @Override
    public void doSomething() {
        System.out.println("I am " + this);
    }
}