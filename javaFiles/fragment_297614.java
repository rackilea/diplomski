/**
 * Extended model that passes the list of actually changed properties
 * in an extended changeEvent.
 */
public static class MyBoundedRangeModel extends DefaultBoundedRangeModel {

    public MyBoundedRangeModel() {
    }

    public MyBoundedRangeModel(int value, int extent, int min, int max) {
        super(value, extent, min, max);
    }

    @Override
    public void setRangeProperties(int newValue, int newExtent, int newMin,
            int newMax, boolean adjusting) {
        int oldMax = getMaximum();
        int oldMin = getMinimum();
        int oldValue = getValue();
        int oldExtent = getExtent();
        boolean oldAdjusting = getValueIsAdjusting();
        // todo: enforce constraints of new values for all
        List<String> changedProperties = new ArrayList<>();
        if (oldMax != newMax) {
           changedProperties.add("maximum"); 
        }
        if (oldValue != newValue) {
            changedProperties.add("value");
        }
        // todo: check and add other properties 
        changeEvent = changedProperties.size() > 0 ? 
                new MyChangeEvent(this, changedProperties) : null;
        super.setRangeProperties(newValue, newExtent, newMin, newMax, adjusting);
    }


}

/**
 * Extended ChangeEvent that provides a list of actually 
 * changed properties. 
 */
public static class MyChangeEvent extends ChangeEvent {

    private List<String> changedProperties;

    /**
     * @param source
     */
    public MyChangeEvent(Object source, List<String> changedProperties) {
        super(source);
        this.changedProperties = changedProperties;
    }

    public List<String> getChangedProperties() {
        return changedProperties;
    }

}