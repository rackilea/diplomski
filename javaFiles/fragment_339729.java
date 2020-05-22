/**
 * Listener for monitoring events about sliding panes.
 */
public interface PanelSlideListener {
    /**
     * Called when a sliding pane's position changes.
     * @param panel The child view that was moved
     * @param slideOffset The new offset of this sliding pane within its range, from 0-1
     */
    public void onPanelSlide(View panel, float slideOffset);
    /**
     * Called when a sliding panel becomes slid completely collapsed.
     * @param panel The child view that was slid to an collapsed position
     */
    public void onPanelCollapsed(View panel);

    /**
     * Called when a sliding panel becomes slid completely expanded.
     * @param panel The child view that was slid to a expanded position
     */
    public void onPanelExpanded(View panel);

    /**
     * Called when a sliding panel becomes anchored.
     * @param panel The child view that was slid to a anchored position
     */
    public void onPanelAnchored(View panel);

    /**
     * Called when a sliding panel becomes completely hidden.
     * @param panel The child view that was slid to a hidden position
     */
    public void onPanelHidden(View panel);
}`

....

 /**
 * Sets the panel slide listener
 * @param listener
 */
public void setPanelSlideListener(PanelSlideListener listener) {
    mPanelSlideListener = listener;
}