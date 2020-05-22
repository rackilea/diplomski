public abstract class Report<T extends Transaction> {
    protected Map<String, T> m = new HashMap<String, T>();
    // more stuff
}

public class TRRTransaction extends Transaction {
    public String someMethodOnlyInTRRTransaction() {
        // do stuff
    }

    @Override
    public void someInheritedMethod() {
        // do stuff
    }
    // more stuff
}

public class TRRReport extends Report<TRRTransaction> {
    public void doSomething() {
        for (B b : m.values()) {
            query.setString(1, b.someMethodOnlyInTRRTransaction());
        }
    }
    // more stuff
}