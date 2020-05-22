public final class Painting extends ArtObject {

    public Painting(final String name) {
        super(name);
    }

    @Override
    public void takeVisitor(final ArtVisitor visitor) {
        visitor.visit(this);
    }

    public void aMethodOnlyPaintingsHave() {
        // whatever...
    }
}