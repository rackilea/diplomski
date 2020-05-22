public interface PropertiesSupplier {

    Properties properties();

    public static final class Properties {

        private final int value1;

        private final String value2;

        private final double value3;

        private Properties(int value1, String value2, double value3) {
            this.value1 = value1;
            this.value2 = value2;
            this.value3 = value3;
        }

        public static Properties of(int value1, String value2, double value3) {
            return new Properties(value1, value2, value3);
        }

        public int getValue1() {
            return this.value1;
        }

        public String getValue2() {
            return this.value2;
        }

        public double getValue3() {
            return this.value3;
        }

        @Override
        public String toString() {
            return "Properties [value1=" + this.value1 + ", value2=" + this.value2 + ", value3=" + this.value3
                    + "]";
        }
    }
}