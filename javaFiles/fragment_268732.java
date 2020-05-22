abstract class Base {
    abstract static class Builder<T extends Builder> {
        private int a;
        private T builder;

        protected void setBuilder(T builder) {
            this.builder = builder;
        }

        T setA(int a) {
            this.a = a;
            return this.builder;
        }

    }
}

public class X extends Base {
    static class Builder extends Base.Builder<Builder> {

        public Builder() {
            super.setBuilder(this);
        }

        X build() {
            // Do some stuff with the configuration
            return new X();
        }
    }

    Builder builder() {
        return new Builder();
    }
}