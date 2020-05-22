public class Response {
    private List<Entry> header;

    private class Entry {
        private Title title;
        private On on;
    }

    private class Title {
        int attempts;
        boolean required;
    }

    private class On {
        String next, event;
    }
}