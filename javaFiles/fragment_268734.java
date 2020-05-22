public class X extends Base {
    static class Builder extends Base.Builder<X> {
        X build() {
            // Do some stuff with the configuration
            return new X();
        }
    }
}