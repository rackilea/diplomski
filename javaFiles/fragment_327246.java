public final class Drawing extends ArtObject {

    public Drawing(final String name) {
        super(name);
    }

    @Override
    public void takeVisitor(final ArtVisitor visitor) {
        visitor.visit(this);
    }
}