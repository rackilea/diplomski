interface InternalContentVisitor<T> {
    T visitText(InternalTextContent c);
    T visitImage(InternalImageContent c);
}

public abstract class InternalContent {
    public abstract <T> T accept(InternalContentVisitor<T> visitor);
    // ...
}

public class InternalTextContent {
    @Override
    public <T> T accept(InternalContentVisitor<T> visitor) {
        return visitor.visitText(this);
    }
}

public class InternalImageContent {
    @Override
    public <T> T accept(InternalContentVisitor<T> visitor) {
        return visitor.visitImage(this);
    }
}