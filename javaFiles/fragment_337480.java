public class ObjectA implements Externalizable {
    @Override
    public void writeExternal(ObjectOutput out) { ... }

    @Override
    public void readExternal(ObjectInput in) { ... }
}