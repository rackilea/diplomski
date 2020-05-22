public interface ElementVisitor<R> extends SpecificVisitor<R>, FancyVisitor<R> {
}

public interface Element {
    public <R> R accept(ElementVisitor<R> visitor);
}