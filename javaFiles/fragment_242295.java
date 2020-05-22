public interface Metric {
    public String getReferenceUnit();
}

public class Distance implements Metric {
    public String getReferenceUnit() {
        return new String("Meters");
    }
}

public interface Units<T extends Metric> {
    public double getToReferenceFactor();
}

public class Kilometers implements Units<Distance> {
    public double getToReferenceFactor() {
        return 1000;
    }
}

static <T extends Metric> double convert(Units<T> from, Units<T> to) {
    return from.getToReferenceFactor() * (1.0 / to.getToReferenceFactor());
}