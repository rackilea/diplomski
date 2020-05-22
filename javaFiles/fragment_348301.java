public class Outer {
    public static class Inner {
        private final Outer I_AM_MAGIC;

        public Inner(Outer outer) {
            this.I_AM_MAGIC = outer;
        }
    }
}