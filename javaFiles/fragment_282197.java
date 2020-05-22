public class BigClonable {

    private Part enclosedThing;

    private Part getEnclosedThing() {
        return enclosedThing;
    }

    /**
     * Call this method after cloning by serialization to copy transient field.
     * @param original The object that this object was cloned from.
     */
    public void finishClone(BigClonable original) {
        // delegate to part object
        enclosedThing.finishClone(original.getEnclosedThing());
    }

}

public class Part {

    private transient List<String> fieldRequiringShallowCopy;

    /** getter to be used by cloning */
    private List<String> getFieldRequiringShallowCopy() {
        return fieldRequiringShallowCopy;
    }

    public void finishClone(Part original) {
        this.fieldRequiringShallowCopy = original.getFieldRequiringShallowCopy();
    }

}