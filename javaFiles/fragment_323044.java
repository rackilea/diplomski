public class TheBase {
    public <T> T asA(Class<T> claxx) {
        if (claxx.isInstance(this)) {
            return claxx.cast(this);
        } else {
            throw new CustomCannotCastException();
        }
    }
}