package de.scrum_master.app;

public class PoolableBusinessLogic {
    @InjectServiceClientAdapter(legacyImpl = LegacyAccountSummary.class, newImpl = NewAccountSummary.class)
    private AccountSummary accountSummary;

    public void foo() {
        accountSummary.doSomething();
    }

    public void bar() {
        System.out.println("Account summary is " + accountSummary);
    }
}