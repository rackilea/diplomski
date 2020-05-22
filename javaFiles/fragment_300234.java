public abstract class RecordType {
    public abstract <T> T accept(RecordTypeVisitor<T> visitor);
}

public interface RecordTypeVisitor<T> {
    T visitOne(RecordType1 recordType);
    T visitTwo(RecordType2 recordType);
}

public class RecordType1 extends RecordType {
    public <T> T accept(RecordTypeVisitor<T> visitor) {
        return visitor.visitOne(this);
    }
}

public class RecordType2 extends RecordType {
    public <T> T accept(RecordTypeVisitor<T> visitor) {
        return visitor.visitTwo(this);
    }
}