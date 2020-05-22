[Serializable]
public class MetaDataKey<T> {

    private Guid uniqueId;
    private Type type;

    public MetaDataKey(Guid key, Type type) {
        this.uniqueId;
        this.type = type;
    }

    public override boolean Equals(object other) {
        return other is MetaDataKey && uniqueId == ((MetaDataKey)other).uniqueId;
    }
}