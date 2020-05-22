public class SetUtil {

    @Nullable
    public static <T> T nthElement(Set<T> set, int n) {
        if (null != set && n >= 0 && n < set.size()) {
            int count = 0;
            for (T element : set) {
                if (n == count)
                    return element;
                count++;
            }
        }
        return null;
    }
}