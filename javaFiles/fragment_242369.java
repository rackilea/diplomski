abstract class MyClass {

    static class FIRST extends MyClass {

        @Override
        public String doIt() {
            return "1: " + someField; // error
        }

    };

    static class SECOND extends MyClass {

        @Override
        public String doIt() {
            return "2: " + super.someField; // no error
        }

    };

    private String someField;

    public abstract String doIt();

}