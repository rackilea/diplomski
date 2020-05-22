public class Root {

    public int route;
    public Info info;

    public static class Info {

        public String direction;
        public Stops stops;

        public static class Stops {
            @JsonProperty("arrival_time")
            public Map<String, String[]> arrivalTime = new HashMap<>();
            @JsonProperty("stops_name")
            public String stopsName;
        }
    }
}