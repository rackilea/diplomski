public interface UniversalSet {
}

public abstract class DiscreteUniversalSet implements UniversalSet {
    public double[] getValues() {...}
}

public abstract class ContinuousUniversalSet implements UniversalSet {
    public double getLowerBound() {...}
    public double getUpperBound() {...}
}

public interface FuzzySet<T extends UniversalSet> {
    T getAlphaIntersection(double alpha);
}

public abstract class DiscreteFuzzySet implements FuzzySet<DiscreteUniversalSet> {
    public DiscreteUniversalSet getAlphaIntersection(double alpha) { ... }
}

public abstract class ContinuousFuzzySet implements FuzzySet<ContinuousUniversalSet> {
    public ContinuousUniversalSet getAlphaIntersection(double alpha) { ... }
}