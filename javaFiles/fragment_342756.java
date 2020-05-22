public class Main {
    static enum Numbers {
        // various instances associated with integers or not
        ZERO(0),ONE(1),FORTY_TWO(42), DEFAULT;
        // int value
        private int value;
        // empty constructor for default value
        Numbers() {}
        // constructor with value
        Numbers(int value) {
            this.value = value;
        }
        // getter for value
        public int getValue() {
            return value;
        }
        // utility method to retrieve instance by int value
        public static Numbers forValue(int value) {
            // iterating values
            for (Numbers n: values()) {
                // matches argument
                if (n.getValue() == value) return n;
            }
            // no match, returning DEFAULT
            return DEFAULT;
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(Numbers.forValue(42));
        System.out.println(Numbers.forValue(10));
    }
}