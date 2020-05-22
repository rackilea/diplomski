public class Dog {
    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}