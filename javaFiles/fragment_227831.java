public interface ViewModel {

    /**
     * Returns the name of the current "active" view name
     * @return
     */
    public String getCurrentView();

    /**
     * Instructs the model to move to the next view if one is
     * available...
     */
    public void nextView();

    /**
     * Instructs the model to move to the previous view if one is
     * available...
     */
    public void previousView();

    /**
     * Returns the number of views in this model
     */
    public int size();

    /**
     * Returns the name of the view at the specified index...
     * @param index
     * @return 
     */
    public String getViewAt(int index);

    /**
     * Adds a ChangeListeners to the model, which will be notified when
     * the current view changes
     */
    public void addChangeListener(ChangeListener listener);

    /**
     * Remove a ChangeListeners from the model
     */
    public void removeChangeListener(ChangeListener listener);

}