public class Channel {

    static class Number {
        public String type; // transient too?

        @JacksonXmlText
        public Integer value;

        public String toString() {
            ...
        }
    }

    public String name;
    public Number number;

    @Override
    public String toString() {
        ...
    }
}