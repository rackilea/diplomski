public class EnumException extends Exception {
    private EnumException() {} // prevent objects from being instantiated elsewhere

    public enum Type {
        BAD_DATA("Bad Data","Supplied data is not valid", "http://www.example.com/moreinfo/baddata"),
        MISSING_DATA("Missing Data","Required data not found", "http://www.example.com/moreinfo/missingdata");

        Type(String title, String genericMessage, String url) {
            // Store input
        }

        public EnumException exception() {
            // construct your exception
            return new EnumException();
        }
    }
}