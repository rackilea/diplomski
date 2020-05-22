public interface StageBuilder<STAGE extends Stage> {
    STAGE build(Specifications specifications);
    boolean canBuild(Specifications specs);
}

public abstract class AbstractStageBuilder<SPEC extends Specifications, STAGE extends Stage> implements StageBuilder<STAGE> {
    private Class<? extends SPEC>
        specClass;

    public AbstractStageBuilder(final Class<? extends SPEC> specClass) {
        this.specClass = specClass;
    }

    @Override
    public boolean canBuild(final Specifications specs) {
        return specClass.isAssignableFrom(specs.getClass());
    }

    @Override
    public STAGE build(Specifications specifications) {
        SPEC spec = specClass.cast(specifications);
        doBuild(spec);
    }

    protected abstract STAGE doBuild(SPEC specifications);
}