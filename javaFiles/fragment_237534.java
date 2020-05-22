class IdSpaceRollingStock extends RollingStock {
    protected final String name;
    protected final String series;
    public IdSpaceRollingStock (int length, boolean couplingFront, boolean couplingBack,
            String name, String series) {
        super(length, couplingFront, couplingBack);
        this.name = name;
        this.series = series;
    }
    ...
}

public abstract class Engine extends IdSpaceRollingStock {
public abstract class Trainset extends IdSpaceRollingStock {