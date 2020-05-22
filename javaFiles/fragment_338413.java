public enum ExampleEnum {

    ONE,

    TWO {
        @Override
        public void print() {
            System.out.println("Two");
        }
    };

    public void print() {
        System.out.println(name());
    }
}