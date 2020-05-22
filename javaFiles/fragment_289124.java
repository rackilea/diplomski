public class Option<U, T extends U> {
    T value;

    public U orElse(U other) {
        if (value != null) {
            return value;
        }
        return other;
    }
}