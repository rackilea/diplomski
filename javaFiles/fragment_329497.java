public interface IFieldObject {
    public<T> Comparable<T> get();
}

public interface IFieldCondition {
    public boolean apply(IFieldObject field, Comparable<?> compare);
}

public class EqualTo implements IFieldCondition {
    public boolean apply(IFieldObject field, Comparable<?> compare) {
        return (field.get().compareTo(compare) == 0);       
    }
}