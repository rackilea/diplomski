public abstract class FancyElement implements Element {
    public abstract <R> R accept(FancyVisitor<R> visitor);

    public <R> R accept(ElementVisitor<R> visitor) {
        return accept((FancyVisitor<R>) visitor);
    }
}