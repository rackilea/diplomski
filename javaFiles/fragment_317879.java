public abstract class SpriteBody {
    private BodyType bodyType;

    protected abstract BodyType determineBodyType();

    public void def() {
        bodyType = computeBodyType();
    }
}

public class Block extends SpriteBody {
    @Override
    protected BodyType determineBodyType() {
        // ... TODO ...
    }
}