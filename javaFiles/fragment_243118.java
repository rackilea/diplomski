public class ListUtils {
    public static List<U> mapObjectToField(List<T> elements, Mapper<T, U> mapper) {
        List<U> result = new ArrayList<>();
        for (T current : elements) {
            result.add(mapper.map(current));
        }
        return result;
    }
}