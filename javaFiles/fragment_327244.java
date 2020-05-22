public abstract class ArtObject {

    private final String name;

    protected ArtObject(final String name) {
        this.name = name;
    }

    public abstract void takeVisitor(ArtVisitor visitor);

    @Override
    public final String toString() {
        return String.format("%s (%s)",
                             this.name,
                             this.getClass().getCanonicalName());
    }
}