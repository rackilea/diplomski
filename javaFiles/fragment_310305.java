public class History {

    // private constructor to hide instance creation
    private History(ABC abc) {
        this.id = abc.getId();
        this.date = new Date(abc.getDate().getTime());
        // ... another common properties
    }

    public History setStatus(Status s) {
        this.status = s;
        return this;
    }

    // public static factory methods to create instances specified by input
    public static History of(A a) {
        History h = new History(a);
        h.type = a.getType();
        // ... properties specific for `A`
        return h;
    }

    public static History of(A a, Status status) {
        return of(a).setStatus(status);
    }

    public static History of(B b) {
        History h = new History(b);
        h.model = b.getModel();
        // ... properties specific for `B`
        return h;
    }

    // ...
}