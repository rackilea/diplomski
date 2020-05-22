public enum Recurrence {
    DAILY,
    MONTHLY,
    BIMONTHLY
}

public enum Distributions {
    GROCERIES(Recurrence.DAILY),
    SUPPLIES(Recurrence.DAILY),
    NEWSPAPER(Recurrence.MONTHLY),
    MAGAZINES(Recurrence.BIMONTHLY);

    private Recurrence recurrence;

    private Distributions(Recurrence recurrence) {
        this.recurrence = recurrence;
    }

    public Recurrence getRecurrence() {
        return this.recurrence;
    }
}

public class SomeObject{
    ...

    private Distributions distribution;

    ...
}