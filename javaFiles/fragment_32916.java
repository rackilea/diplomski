public class Builder<T> {

    public final class With<R> {
        private final Function<T,R> method;

        private With(Function<T,R> method) {
            this.method = method;
        }

        public Builder<T> of(R value) {
            // TODO: Body of your old 'with' method goes here
            return Builder.this;
        }
    }

    public <R> With<R> with(Function<T,R> method) {
        return new With<>(method);
    }

}