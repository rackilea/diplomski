abstract class Mode {
    public abstract <T> T accept(ModeVisitor<T> visitor);
}

final class RealTime extends Mode {
    public RealTime() {}

    public <T> T accept(ModeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

final class Sampled extends Mode {
    private final int interval;

    public Sampled(int interval) {
        this.interval = interval;
    }

    public int getInterval() {
        return this.interval;
    }

    public <T> T accept(ModeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

// The recursion principle itself
abstract class ModeVisitor<T> {
    public abstract T visit(RealTime mode);
    public abstract T visit(Sampled mode);
}

// Concrete uses of the recursion principle
final class ModeShow extends ModeVisitor<String> {
    private ModeShow() {}

    public static String show(Mode mode) {
        return mode.accept(new ModeShow());
    }

    public String visit(RealTime mode) {
        return "RealTime";
    }

    public String visit(Sampled mode) {
        return "Sampled " + mode.getInterval();
    }
}