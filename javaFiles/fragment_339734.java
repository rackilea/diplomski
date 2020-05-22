public class GSONClass {
    private Response json;

    public static class Response {
        private String[] errors;
        private Data data;
    }

    public static class Data {
        private String modhash = "hi";
        private String cookie;
    }
}