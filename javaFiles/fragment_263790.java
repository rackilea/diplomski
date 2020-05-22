public abstract class Root {
    ...
    protected final void finishInit() {
        // Do post-processing
    }
}

public abstract class Intermediate {
    ...
    protected Intermediate(...) {
        super(...);
        ...
        // don't call finishInit();
    }
    ...
}

public class Leaf {
    ...
    public Leaf(...) {
       super(...);
       ...
       finishInit();
    }
    ...
}