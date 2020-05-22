public class MyClass {
    public String time;
    public Query query;

    public static class Query {
        public Map<String, Page> pages; // <-- here

        public static class Page {
            public String title;
            public String pagelanguage;
        }
    }
}