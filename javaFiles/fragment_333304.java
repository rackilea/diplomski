import java.util.List;

public class CastExample <T extends Object> {
    public List<T> typedList;
    public List<?> untypedList;

    public T getFirstElement() {
        return typedList.get(0);
    }


    public T getFromUntypedArray() {
        return (T) untypedList.get(0);
    }
}