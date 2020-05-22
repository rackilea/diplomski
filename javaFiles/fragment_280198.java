public interface StageBuilder<STAGE extends Stage> {
    Optional<Supplier<STAGE>> supplier(Specifications specifications);
}

public abstract class AbstractStageBuilder<SPEC extends Specifications, STAGE extends Stage> implements StageBuilder<STAGE> {
    private Class<? extends SPEC>
        specClass;

    public AbstractStageBuilder(final Class<? extends SPEC> specClass) {
        this.specClass = specClass;
    }

    @Override
    public Optional<Supplier<Stage>> supplier(final Specifications specs) {
        if( specClass.isAssignableFrom(specs.getClass()) ) {
            return Optional.of( () -> this.build(specClass.cast(specs)) );
        } else {
            return Optional.empty();
        }
    }

    protected abstract STAGE build(SPEC specifications);
}