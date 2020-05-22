public class Test {
abstract static class AbstractSample {

    private String as;

    //this method needs to be overriden
    public abstract SampleBuilder<? extends AbstractSample, ?> copyBuilder();

    public static abstract class SampleBuilder<T extends AbstractSample, B extends SampleBuilder<T, B>> {

        private String as;

        public SampleBuilder(AbstractSample object) {
            this.as = object.as;
        }

        public B as(String as) {
            this.as = as;
            return (B) this;
        }

        public abstract T build();
    }
}

static class Sample1 extends AbstractSample {

    @Override
    public SampleBuilder<? extends Sample1, ?> copyBuilder() {
        return new Builder(this);
    }

    public static class Builder extends SampleBuilder<Sample1, Builder> {

        public Builder(Sample1 sample1) {
            super(sample1);
        }

        @Override
        public Sample1 build() {
            return null;
        }
    }
}

static class Sample2 extends Sample1 {

    @Override
    public SampleBuilder<? extends Sample2, ?> copyBuilder() {
        return new Builder(this);
    }

    public static class Builder extends SampleBuilder<Sample2, Builder> {

        public Builder(Sample2 sample2) {
            super(sample2);
        }

        @Override
        public Sample2 build() {
            return null;
        }
    }
}
}