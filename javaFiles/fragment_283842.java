public class Hub extends AbstractPeripheral {
    public static class Builder extends AbstractPeripheral.Builder<Hub, Builder> {
        public static final Builder builder() {
            return new Builder();
        }
        public Builder self() {
            return this;
        }
        public Hub build() {
            return new Hub();
        }
    }
}