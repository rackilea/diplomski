/**
 * Gets a new instance of this class to be used as a next renderer, after this renderer is used, if
 * {@link #layout(LayoutContext)} is called more than once.
 * @return new renderer instance
 */
IRenderer getNextRenderer();