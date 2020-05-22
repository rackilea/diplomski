/**
 * When panels (Ex: VerticalSplitPanel) are resized, adjust the positions.
 */
public class ResizeEvent extends GwtEvent<ResizeEventHandler> {

    /* **************************************** */
    // Public Static Fields
    /* **************************************** */
    /** The Constant TYPE. */
    public static final Type<ResizeEventHandler> TYPE = new Type<ResizeEventHandler>();

    /* **************************************** */
    // Private Fields
    /* **************************************** */
    /** The split size. */
    private final int splitSize;

    /* **************************************** */
    // Constructors
    /* **************************************** */
    /**
     * Instantiates a new view set event.
     * 
     * @param splitSize
     *            The split size.
     */
    public ResizeEvent(final int splitSize) {
        this.splitSize = splitSize;
    }

    /* **************************************** */
    // Public Properties
    /* **************************************** */
    /** {@inheritDoc} */
    @Override
    public Type<ResizeEventHandler> getAssociatedType() {
        return ResizeEvent.TYPE;
    }

    /**
     * Gets the top position.
     * 
     * @return The split position.
     */
    public int getSplitSize() {
        return splitSize;
    }

    /* **************************************** */
    // Protected Methods
    /* **************************************** */
    /** {@inheritDoc} */
    @Override
    protected void dispatch(final ResizeEventHandler handler) {
        handler.onResize(this);
    }

}