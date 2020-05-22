public class MyClonable {

    private transient List<String> fieldRequiringShallowCopy;

    /** getter to be used by cloning */
    private List<String> getFieldRequiringShallowCopy() {
        return fieldRequiringShallowCopy;
    }

    /**
     * Call this method after cloning by serialization to copy transient field.
     * @param original The object that this object was cloned from.
     */
    public void finishClone(MyClonable original) {
        this.fieldRequiringShallowCopy = original.getFieldRequiringShallowCopy();
    }

}