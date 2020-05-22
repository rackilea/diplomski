public enum Move { RED, GREEN, BLUE }

public interface MoveStrategy
{
    public void move(final int spaces);
}

public abstract class BaseMoveStrategy
{
    protected final Canvas canvas;

    protected BaseMoveStrategy(@Nonnull final Canvas canvas) { this.canvas = canvas; }
}

public class MoveRed extends BaseMoveStrategy implements MoveStrategy
{
    public MoveRed(@Nonnull final Canvas canvas) { super(canvas); }

    @Override public void move(final int spaces) { /* logic for Red goes here */ }
}

public class MoveBlue extends BaseMoveStrategy implements MoveStrategy
{
    public MoveBlue(@Nonnull final Canvas canvas) { super(canvas); }

    @Override public void move(final int spaces) { /* logic for Blue goes here */ }
}

public class MoveGreen extends BaseMoveStrategy implements MoveStrategy
{
    public MoveGreen(@Nonnull final Canvas canvas) { super(canvas); }

    @Override public void move(final int spaces) { /* logic for Green goes here */ }
}