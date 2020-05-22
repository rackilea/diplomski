public class Thing {
    public Thing (Leaker leaker) {
        leaker.leak(this);
    }
}

public class NamedThing  extends Thing {
    private String name;

    public NamedThing (Leaker leaker, String name) {
        super(leaker);

    }

    public String getName() {
        return name; 
    }
}