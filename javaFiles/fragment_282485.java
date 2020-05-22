public class FancyElement1 extends FancyElement {
    public <R> R accept(FancyVisitor<R> visitor) {
        return visitor.visit(this);
    }
}

public interface FancyVisitor<R> {
    public R visit(FancyElement1 e);
    // ...
}